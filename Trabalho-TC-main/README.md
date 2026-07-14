# Intersecção e Reverso de Autômatos — nosso tema no Trabalho de TC

A aplicação (preexistente, do repositório do grupo) importa autômatos finitos no formato `.jff` do JFLAP, aplica operações regulares e salva o resultado em um novo `.jff`. **A aplicação não é nossa** — nossa contribuição é exclusivamente o tema **Intersecção** e **Reverso**, adicionado com o mínimo de modificações:

| Arquivo | O que adicionamos |
|---|---|
| `src/entities/OperacoesAutomato.java` | Métodos `interseccao(File, File)` e `reverso(File)` + auxiliares privados (`temTransicaoVazia`, `posicaoDoEstado`, `idDoPar`, `inverterTransicoes`, `criarInicialComTransicoesVazias`) |
| `src/gui/enums/Operacao.java` | Valores `INTERSECCAO` e `REVERSO` (os botões da janela nascem sozinhos a partir do enum) |
| `src/Program.java` | Dois ramos de despacho em `processarOperacao` e a condição de 2 arquivos para a intersecção |
| `src/gui/JanelaInicial.java` | Grade de botões dimensionada pelo enum + texto da dica |
| `src/gui/SeletorArquivos.java` | Títulos dos diálogos de 2 arquivos generalizados (eram exclusivos da Diferença Simétrica) |

Todo o resto — parser do `.jff`, entidades (`AutomatoFinito`, `Estado`, `Transicao`), salvamento, GUI e as demais operações (Complemento, Estrela, Diferença Simétrica) — já existia e não é assunto da nossa apresentação.

**Contexto mínimo para entender nosso código** (não apresentar como conteúdo): a aplicação carrega o `.jff` (XML do JFLAP) e o transforma em um `AutomatoFinito`, que guarda uma lista de `Estado` (id, nome, flags `inicial` e `final_`) e uma lista de `Transicao` (`de`, `para`, `simbolo`). A transição vazia (ε) é o símbolo `""`. Nossos métodos recebem o(s) arquivo(s), devolvem um `AutomatoFinito` novo, e a aplicação cuida de salvar e abrir no JFLAP.

---

## PARTE 1 — EXPLICAÇÃO DO QUE ADICIONAMOS (consumo interno do grupo)

### 1.1 Intersecção — método do produto cartesiano

**Teoria.** A intersecção de L(M1) e L(M2) aceita somente as cadeias aceitas **pelos dois** autômatos ao mesmo tempo. A construção clássica simula os dois em paralelo:

- **Estados**: Q = Q1 × Q2 — cada estado novo é um par (p, q);
- **Inicial**: q0 = (q01, q02) — o par dos dois iniciais;
- **Transições**: δ((p,q), a) = (δ1(p,a), δ2(q,a)) — os dois andam juntos sob o **mesmo símbolo**;
- **Finais**: F = {(p,q) | p ∈ F1 **e** q ∈ F2}.

**Código — validação e estados.** Primeiro, o guard: o produto não funciona com transições vazias, porque o ε anda "sozinho" em um autômato sem consumir símbolo, quebrando o sincronismo. Depois, dois `for` aninhados criam um estado para cada par:

```java
if (temTransicaoVazia(a1) || temTransicaoVazia(a2)) {
    throw new IllegalArgumentException("A intersecção não aceita autômatos com transições vazias.");
}
...
for (int i = 0; i < estados1.size(); i++) {
    for (int j = 0; j < estados2.size(); j++) {
        Estado p = estados1.get(i);
        Estado q = estados2.get(j);

        int novoId = i * estados2.size() + j;
        String novoNome = p.getNome() + "," + q.getNome();
        boolean novoInicial = p.isInicial() && q.isInicial();
        boolean novoFinal = p.isFinal_() && q.isFinal_();

        novosEstados.add(new Estado(novoId, novoNome, novoInicial, novoFinal));
    }
}
```

As duas linhas com `&&` **são** a definição matemática traduzida literalmente. O id do par usa a conta de tabela `i * tamanho2 + j` (linha × colunas + coluna), que gera um número único por célula.

**Código — transições.** Para cada par de transições (uma de cada autômato) com o mesmo símbolo, nasce uma transição do par de origens para o par de destinos:

```java
for (Transicao t1 : a1.getTransicoes()) {
    for (Transicao t2 : a2.getTransicoes()) {
        if (t1.getSimbolo().equals(t2.getSimbolo())) {
            int novoDe = idDoPar(estados1, estados2, t1.getDe(), t2.getDe());
            int novoPara = idDoPar(estados1, estados2, t1.getPara(), t2.getPara());

            novasTransicoes.add(new Transicao(novoDe, novoPara, t1.getSimbolo()));
        }
    }
}
```

O auxiliar `idDoPar` converte os dois ids na mesma conta de tabela, usando `posicaoDoEstado` porque os ids do arquivo podem não vir em sequência (0, 1, 2...).

**Pontos de defesa:** funciona para AFD **e** AFN (combinar todos os pares de transições com o mesmo símbolo preserva o não-determinismo); pares inalcançáveis podem existir, mas não alteram a linguagem aceita; o tamanho do resultado é |Q1| × |Q2|.

### 1.2 Reverso

**Teoria.** Lᴿ contém as cadeias de L lidas de trás para frente. Se o autômato aceita `w` por um caminho do inicial até um final, o **mesmo caminho andado ao contrário** lê `w` invertida. Receita: inverter todas as setas; o inicial antigo vira o único final; os finais antigos viram a partida. Como só pode haver **um** estado inicial e podem existir **vários** finais antigos, cria-se um inicial novo com transições vazias (ε) para cada final antigo — o que em geral produz um AFN (e tudo bem: AFN e AFD reconhecem as mesmas linguagens).

**Código — fluxo do método `reverso`:**

```java
inverterTransicoes(automato);

for (Estado estado : automato.getEstados()) {
    estado.setInicial(false);
    estado.setFinal_(false);
}

inicialAntigo.setFinal_(true);

if (finaisAntigos.size() == 1) {
    finaisAntigos.get(0).setInicial(true);
} else {
    criarInicialComTransicoesVazias(automato, finaisAntigos);
}
```

Antes disso o método localiza `inicialAntigo` e `finaisAntigos` e valida a entrada (sem inicial ou sem finais → `IllegalArgumentException`, que a aplicação exibe como diálogo de erro).

**Código — os dois auxiliares:**

```java
private static void inverterTransicoes(AutomatoFinito automato) {
    for (Transicao t : automato.getTransicoes()) {
        int de = t.getDe();
        t.setDe(t.getPara());
        t.setPara(de);
    }
}

private static void criarInicialComTransicoesVazias(AutomatoFinito automato, List<Estado> destinos) {
    int novoId = 0;

    for (Estado estado : automato.getEstados()) {
        if (estado.getId() >= novoId) {
            novoId = estado.getId() + 1;
        }
    }

    Estado novoInicial = new Estado(novoId, "q" + novoId, true, false);
    automato.getEstados().add(novoInicial);

    for (Estado destino : destinos) {
        automato.getTransicoes().add(new Transicao(novoId, destino.getId(), ""));
    }
}
```

A inversão troca `de` e `para` com variável temporária. O id do estado novo é o maior id existente + 1. O símbolo `""` é exatamente como o JFLAP representa o ε. Com **um só** final antigo, ele mesmo vira o inicial — sem estado extra.

### 1.3 Integração com a aplicação (o mínimo que tocamos)

```java
INTERSECCAO("Intersecção"),
REVERSO("Reverso");
```

Adicionar os valores ao enum faz os botões aparecerem sozinhos, porque a janela percorre `Operacao.values()`. No `Program`, dois ramos `else if` seguem o padrão dos já existentes, e a intersecção entrou na condição que pede dois arquivos:

```java
if (operacao == Operacao.DIFERENCA_SIMETRICA || operacao == Operacao.INTERSECCAO) {
    return seletorArquivos.selecionarDoisArquivos(null);
}
```

### 1.4 Validação que fizemos

Testamos por força bruta: simulamos os autômatos gerados para **todas as cadeias de {a,b} até tamanho 7** e comparamos com a linguagem esperada — intersecção de "nº par de a's" com "contém b"; reverso de "termina em ab" (vira "começa com ba"); reverso com dois finais (cria o estado novo com ε). Os `.jff` usados estão em `exemplos/`.

---

## PARTE 2 — ROTEIRO DA APRESENTAÇÃO (15 minutos, 7 integrantes)

> A apresentação cobre **somente o nosso tema**. A aplicação em volta é citada como contexto em uma frase e pronto. Cada um treina cronometrando; slide com pouco texto e fonte grande no código.

| # | Integrante | Bloco | Tempo |
|---|------------|-------|-------|
| 1 | Gabriel de Jesus Santos | Introdução, contexto e como nossas operações se conectam | 2:30 |
| 2 | João Victor Santos do Nascimento | Intersecção: a teoria do produto cartesiano | 2:00 |
| 3 | Edson Ulisses de Melo Sobrinho | Intersecção no código I: os estados-pares | 2:00 |
| 4 | Marina Mendonça Santana | Intersecção no código II: transições síncronas e o caso ε | 2:15 |
| 5 | Kai Augusto Guimarães de Jesus | Reverso: a teoria da inversão | 2:00 |
| 6 | Jeanerson de Jesus Nogueira | Reverso no código: passo a passo | 2:15 |
| 7 | Gabriel Carvalho Tenório | Conclusão e demonstração ao vivo | 2:00 |

---

### 1) GABRIEL DE JESUS SANTOS — 2:30 — Introdução, contexto e conexão

**Bloco de código (slide 3):**

```java
INTERSECCAO("Intersecção"),
REVERSO("Reverso");
```

```java
else if (operacao == Operacao.INTERSECCAO) {
    resultadoFinal = OperacoesAutomato.interseccao(
            arquivosEntrada.get(0),
            arquivosEntrada.get(1)
    );
}

else if (operacao == Operacao.REVERSO) {
    resultadoFinal = OperacoesAutomato.reverso(arquivosEntrada.getFirst());
}
```

**Fala sugerida:**
> "Boa tarde. O nosso tema são duas operações regulares sobre autômatos finitos: a **intersecção** e o **reverso**. Trabalhamos em cima de uma aplicação já existente do grupo, que carrega autômatos no formato `.jff` do JFLAP, transforma o XML em objetos na memória — estados e transições — e salva o resultado de volta em `.jff`. Essa estrutura não é assunto de hoje: o nosso trabalho foi adicionar as duas operações a ela com o mínimo de modificações.
>
> E onde o nosso código se pluga? Em dois pontos. Primeiro, adicionamos dois valores ao enum de operações — e só isso já faz os botões aparecerem na janela, porque a interface percorre os valores do enum e cria um botão para cada. Segundo, dois ramos no despacho da aplicação: escolhida a Intersecção, ela pede **dois** arquivos e chama o nosso método `interseccao`; escolhido o Reverso, pede **um** arquivo e chama o `reverso`. Os dois métodos moram na classe `OperacoesAutomato` e devolvem um autômato pronto, que a aplicação salva sozinha.
>
> A partir de agora o grupo apresenta os dois algoritmos: primeiro a intersecção, com o João Victor na teoria, depois o reverso. No final tem demonstração ao vivo."

**Slides:**
- *Slide 1 (capa):* "Intersecção e Reverso de Autômatos Finitos", nomes dos 7 integrantes, disciplina.
- *Slide 2:* fluxo em uma linha: `.jff → autômato em memória → [NOSSO CÓDIGO: ∩ ou ᴿ] → .jff → JFLAP`, com o bloco "NOSSO CÓDIGO" destacado em cor.
- *Slide 3:* os dois trechos acima; bullets: "2 valores no enum = 2 botões novos", "Intersecção: 2 arquivos · Reverso: 1 arquivo".

---

### 2) JOÃO VICTOR SANTOS DO NASCIMENTO — 2:00 — Intersecção: teoria do produto cartesiano

**Sem bloco de código (bloco todo teórico).**

**Fala sugerida:**
> "A intersecção de duas linguagens regulares contém só as cadeias que os **dois** autômatos aceitam ao mesmo tempo. Como construir um autômato único que verifica as duas condições de uma vez? A resposta clássica é o **produto cartesiano**: um autômato que simula os dois originais **em paralelo**, como se cada um lesse a mesma cadeia na sua própria pista.
>
> A construção formal tem quatro peças. Os **estados**: Q1 vezes Q2 — cada estado novo é um **par** (p, q), que significa 'o primeiro autômato está em p e o segundo está em q'. O **inicial**: o par dos dois iniciais, porque os dois começam juntos. As **transições**: delta do par (p,q) lendo 'a' é o par das duas transições individuais lendo o **mesmo** 'a' — os dois andam sincronizados. E os **finais**: o par é final somente se **as duas** componentes são finais — é aí que mora o 'E' da intersecção.
>
> Um exemplo rápido [aponta o slide]: um autômato de 2 estados que aceita 'número par de a's' com um de 2 estados que aceita 'contém pelo menos um b' gera 2 vezes 2, quatro pares. A cadeia só é aceita se termina num par onde as duas condições valem juntas. O Edson mostra agora como isso vira código."

**Slides:**
- *Slide 4:* as quatro definições em notação: Q = Q1 × Q2; q0 = (q01, q02); δ((p,q),a) = (δ1(p,a), δ2(q,a)); F = {(p,q) | p ∈ F1 e p... q ∈ F2} — cada uma com uma legenda de meia linha em português.
- *Slide 5:* desenho dos dois autômatos de 2 estados e a grade 2×2 dos pares, com o par duplamente final circulado.

---

### 3) EDSON ULISSES DE MELO SOBRINHO — 2:00 — Intersecção no código I: os estados-pares

**Bloco de código (slide 6):**

```java
for (int i = 0; i < estados1.size(); i++) {
    for (int j = 0; j < estados2.size(); j++) {
        Estado p = estados1.get(i);
        Estado q = estados2.get(j);

        int novoId = i * estados2.size() + j;
        String novoNome = p.getNome() + "," + q.getNome();
        boolean novoInicial = p.isInicial() && q.isInicial();
        boolean novoFinal = p.isFinal_() && q.isFinal_();

        novosEstados.add(new Estado(novoId, novoNome, novoInicial, novoFinal));
    }
}
```

**Fala sugerida:**
> "O produto cartesiano que o João Victor definiu vira este par de laços aninhados: para cada estado do primeiro autômato, combinado com cada estado do segundo, nasce um estado novo no resultado.
>
> Reparem que cada linha do corpo corresponde a uma peça da definição. O **nome** do estado novo é o nome dos dois, separados por vírgula — é o par (p, q) escrito como texto, e é assim que ele aparece no JFLAP. O **inicial**: verdadeiro só se `p` é inicial **e** `q` é inicial — o par dos dois iniciais. O **final**: verdadeiro só se os dois são finais — o 'E' da intersecção está literalmente neste `&&`.
>
> E o **id**? Cada par precisa de um número único, e usamos a conta `i * tamanho2 + j`. Pensem numa tabela: `i` é a linha, `j` é a coluna, e a conta devolve o número da célula, contando por linhas. Com 2 estados de um lado e 3 do outro, saem 6 pares numerados de 0 a 5, sem repetição. Essa mesma conta vai reaparecer no bloco da Marina, quando as transições precisarem apontar para esses pares."

**Slides:**
- *Slide 6:* o bloco de código com as duas linhas de `&&` destacadas em cor; ao lado, tabela 2×3 ilustrando `id = i * 3 + j`; bullet único: "cada linha do laço = uma peça da definição".

---

### 4) MARINA MENDONÇA SANTANA — 2:15 — Intersecção no código II: transições síncronas e o caso ε

**Bloco de código (slide 7):**

```java
for (Transicao t1 : a1.getTransicoes()) {
    for (Transicao t2 : a2.getTransicoes()) {
        if (t1.getSimbolo().equals(t2.getSimbolo())) {
            int novoDe = idDoPar(estados1, estados2, t1.getDe(), t2.getDe());
            int novoPara = idDoPar(estados1, estados2, t1.getPara(), t2.getPara());

            novasTransicoes.add(new Transicao(novoDe, novoPara, t1.getSimbolo()));
        }
    }
}
```

**Fala sugerida:**
> "O Edson criou os pares; eu mostro como eles se conectam. A definição diz que os dois autômatos andam **juntos**, sob o **mesmo símbolo**. No código: para cada transição do primeiro autômato, comparada com cada transição do segundo, **se os símbolos são iguais**, nasce uma transição no produto — saindo do par das duas origens e chegando no par dos dois destinos.
>
> O auxiliar `idDoPar` faz a mesma conta de tabela que o Edson mostrou, com um detalhe: antes ele converte o id de cada estado para a posição dele na lista, porque os ids que vêm do arquivo podem não ser 0, 1, 2 em sequência.
>
> Dois pontos de defesa. Primeiro: **funciona para AFN?** Sim — como combinamos **todos** os pares de transições com o mesmo símbolo, se um lado tem duas saídas com 'a', o produto ganha as duas combinações; o não-determinismo é preservado. Segundo: **e a transição vazia?** Essa nós recusamos de propósito: o ε permite que um autômato ande sem consumir símbolo enquanto o outro fica parado, e isso quebra o sincronismo do produto. Por isso a primeira coisa que o método faz é verificar os dois autômatos e lançar uma exceção com mensagem clara, que a aplicação mostra como janela de erro — em vez de gerar um resultado silenciosamente errado."

**Slides:**
- *Slide 7:* o bloco de código com o `if` do símbolo destacado; a fórmula δ((p,q),a) = (δ1(p,a), δ2(q,a)) no topo; bullets: "mesmo símbolo = andam juntos", "AFN ok: todos os pares de transições", "ε recusado → diálogo de erro".

---

### 5) KAI AUGUSTO GUIMARÃES DE JESUS — 2:00 — Reverso: a teoria da inversão

**Sem bloco de código (bloco todo teórico).**

**Fala sugerida:**
> "A segunda operação do nosso tema é o reverso: a linguagem com as mesmas cadeias, lidas de trás para frente. A construção tem uma intuição bonita: se o autômato aceita a palavra `w` percorrendo um caminho do estado inicial até um final, então esse **mesmo caminho, andado ao contrário**, lê exatamente `w` invertida.
>
> Disso sai a receita em três passos. Primeiro: **inverter o sentido de todas as setas** — cada transição de p para q vira de q para p. Segundo: o **inicial antigo vira o único estado final** — porque todo caminho invertido termina onde o original começava. Terceiro: os **finais antigos viram a partida** — porque todo caminho invertido começa onde o original terminava.
>
> Só que o terceiro passo tem um problema: podem existir **vários** finais antigos, e um autômato só pode ter **um** estado inicial. A solução clássica: criar um estado inicial novo, ligado a cada final antigo por uma **transição vazia** — o ε. O autômato 'escolhe' de graça, sem consumir símbolo, por qual antigo final começar. Consequência: o reverso de um AFD em geral é um **AFN** — setas invertidas podem criar não-determinismo e o ε também. E não tem problema nenhum: AFN e AFD reconhecem exatamente a mesma família de linguagens. O Jeanerson mostra isso virando código."

**Slides:**
- *Slide 8:* autômato de 3 estados e seu reverso lado a lado, setas invertidas em cor diferente; os três passos numerados em uma linha cada.
- *Slide 9:* o caso "vários finais": desenho do estado novo com setas ε tracejadas para os antigos finais; bullet: "reverso de AFD pode ser AFN — e tudo bem".

---

### 6) JEANERSON DE JESUS NOGUEIRA — 2:15 — Reverso no código: passo a passo

**Bloco de código (slide 10):**

```java
inverterTransicoes(automato);

for (Estado estado : automato.getEstados()) {
    estado.setInicial(false);
    estado.setFinal_(false);
}

inicialAntigo.setFinal_(true);

if (finaisAntigos.size() == 1) {
    finaisAntigos.get(0).setInicial(true);
} else {
    criarInicialComTransicoesVazias(automato, finaisAntigos);
}
```

**Fala sugerida:**
> "O método `reverso` segue exatamente os três passos que o Kai apresentou, e dividimos cada um em métodos pequenos para ficar legível.
>
> Antes de mexer em qualquer coisa, o método guarda quem era o inicial e quem eram os finais, e **valida**: autômato sem inicial ou sem nenhum final é rejeitado com mensagem de erro.
>
> Aí vem a sequência do slide. `inverterTransicoes` percorre todas as transições trocando o `de` com o `para` — uma troca com variável temporária, igual à troca de valores entre duas variáveis de Programação I. Depois o laço zera os papéis de todo mundo, e o inicial antigo recebe `setFinal_(true)`: ele é o único final do reverso.
>
> E o `if` final é o pulo do gato que o Kai explicou. Se havia **um só** final antigo, ele mesmo vira o inicial — sem criar nada. Se havia **vários**, o auxiliar `criarInicialComTransicoesVazias` entra em ação: calcula um id novo como o maior id existente mais um, cria o estado inicial novo, e liga ele a cada final antigo com uma transição de símbolo vazio — a string vazia é como o JFLAP representa o ε. O autômato resultante volta para a aplicação, que salva o `.jff` sozinha."

**Slides:**
- *Slide 10:* o bloco de código acima com o `if/else` destacado; bullets: "1 final antigo → ele vira o inicial", "vários → estado novo + ε (`\"\"`)", "valida antes: sem inicial/final = erro".

---

### 7) GABRIEL CARVALHO TENÓRIO — 2:00 — Conclusão e demonstração ao vivo

**Sem bloco de código novo (usa a aplicação rodando).**

**Fala sugerida:**
> "Para fechar, a demonstração. [DEMO] Rodo a aplicação e aparecem as operações — as duas do nosso tema entraram aqui pelos valores do enum. Escolho **Intersecção** e seleciono dois autômatos: um que aceita cadeias com número **par de a's** e outro que aceita cadeias com **pelo menos um b**. Salvo e abro no JFLAP: os estados são os pares, com os nomes compostos por vírgula. Testando: 'aab' é **aceita** — dois a's, tem b. 'ab' é **rejeitada** — um 'a' só, ímpar. Exatamente a intersecção das duas condições.
>
> Agora o **Reverso**, com o autômato que aceita cadeias terminadas em 'ab'. No resultado, as setas aparecem invertidas, e testando: 'ba' é aceita, 'ab' não — a linguagem virou 'começa com ba', que é o reverso de 'termina em ab'.
>
> Resumindo o nosso tema: a **intersecção** constrói o produto cartesiano — pares de estados, transições síncronas sob o mesmo símbolo, final onde os dois são finais. O **reverso** inverte as setas e troca os papéis de inicial e final, usando transições vazias quando há vários finais. Tudo isso entrou na aplicação existente com o mínimo de modificações: dois métodos novos, dois valores de enum e dois ramos de despacho. Obrigado! Ficamos abertos a perguntas."

**Slides:**
- *Slide 11:* recap em 2 linhas: "∩ = produto cartesiano (pares, símbolo síncrono, final && final)" / "ᴿ = setas invertidas + papéis trocados (+ ε se vários finais)".
- *Slide 12 (encerramento):* "Perguntas?"; nomes do grupo.

**Checklist da demo (fazer ANTES da apresentação):**
- [ ] Testar a aplicação na máquina/projetor da sala;
- [ ] Levar os arquivos da pasta `exemplos/`: `par_de_a.jff`, `tem_b.jff`, `termina_ab.jff`, `tamanho_um.jff`;
- [ ] Ensaiar as cadeias no JFLAP: intersecção aceita `aab`/`baa` e rejeita `ab`; reverso aceita `ba...` e rejeita `ab...`;
- [ ] Plano B: screenshots/vídeo da execução caso o Java da sala falhe.

---

## Possíveis perguntas do professor (e respostas curtas)

1. **"Por que a intersecção não aceita ε-transição?"** — O produto exige que os dois autômatos consumam o mesmo símbolo juntos; o ε anda sozinho sem consumir nada e quebra o sincronismo. Detectamos e mostramos erro claro.
2. **"O produto funciona para AFN?"** — Sim: combinamos todos os pares de transições com o mesmo símbolo, preservando o não-determinismo dos dois lados.
3. **"O reverso de um AFD é sempre AFD?"** — Não, em geral vira AFN: setas invertidas criam não-determinismo e vários finais antigos viram várias partidas via ε.
4. **"E os pares inalcançáveis do produto?"** — Podem existir; não alteram a linguagem aceita, só o desenho.
5. **"Quantos estados tem o produto?"** — |Q1| × |Q2|; no exemplo da demo, 2 × 2 = 4.
6. **"Por que criar estado novo só quando há mais de um final antigo?"** — Com um único final antigo ele mesmo pode assumir o papel de inicial; o estado extra com ε só é necessário para juntar vários pontos de partida em um.
