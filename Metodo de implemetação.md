**Intersecção (Método do Produto Cartesiano)**:

* **Conceito Formal**: A intersecção de duas linguagens regulares $L(M_1)$ e $L(M_2)$ resulta em uma nova linguagem regular contendo apenas as cadeias aceitas simultaneamente por ambos os autômatos.
* **Construção de Estados ($Q$)**: O conjunto de estados do novo autômato é definido pelo produto cartesiano $Q = Q_1 \times Q_2$. Cada estado resultante é um par ordenado $(p, q)$, onde $p \in Q_1$ e $q \in Q_2$.
* **Estado Inicial ($q_0$)**: O estado de partida único é o par formado pelos estados iniciais correspondentes de cada autômato: $q_0 = (q_{01}, q_{02})$.
* **Função de Transição ($\delta$)**: As transições ocorrem de forma síncrona sob o mesmo símbolo do alfabeto. Para cada par de estados $(p, q)$ e símbolo $a \in \Sigma$, a transição é dada por:

$$\delta((p, q), a) = (\delta_1(p, a), \delta_2(q, a))$$


* **Estados Finais ($F$)**: Um estado composto $(p, q)$ será final se, e somente se, **ambos** os estados componentes forem finais em seus respectivos autômatos de origem:

$$F = \{(p, q) \mid p \in F_1 \text{ e } q \in F_2\}$$



---

**Reverso ($M^R$)**:

* **Conceito Formal**: O reverso de uma linguagem $L$, representada por $L^R$, consiste em todas as cadeias de $L$ lidas na ordem inversa (de trás para frente).
* **Inversão do Fluxo de Transições**: Para cada transição original do autômato de origem $p \xrightarrow{a} q$, o sentido do arco é invertido na estrutura resultante, tornando-se $q \xrightarrow{a} p$.
* **Inversão de Papéis dos Estados**:
* O estado inicial original ($q_0$) passa a ser o único estado de aceitação (final) do novo autômato.
* O conjunto de estados finais originais ($F$) passa a atuar como o conjunto de estados de partida (iniciais).


* **Adaptação Determinística/Não-Determinística via Transições-Vazias ($\epsilon$)**: Como um autômato pode possuir múltiplos estados finais originais, o reverso resultante passa a ter múltiplos pontos de partida, o que requer a criação de um único novo estado inicial $q_{start}$. Desse novo estado, realizam-se transições espontâneas sem consumo de caracteres ($\epsilon$-transições) para cada um dos antigos estados finais.


Aqui está uma sugestão de texto revisada e estruturada para você adicionar às diretrizes do seu grupo ou enviar para o assistente de desenvolvimento, deixando claro o alinhamento técnico e o estilo de código esperado:

---

## Alinhamento de Nível Técnico e Estilo de Código

Para garantir que todo o desenvolvimento seja condizente com a realidade do nosso grupo e perfeitamente compreensível por todos os integrantes na hora da apresentação, estabelecemos os seguintes parâmetros de programação:

### 1. Teto de Conhecimento Técnico (Baseline em Java)

* **Referência de Linguagem**: Embora esta seja uma disciplina de **Teoria da Computação**, o nosso limite técnico e teto de capacidade prática em Java é baseado estritamente no conteúdo programático da disciplina de **Programação III**.
* **Complexidade do Código**: Não utilizaremos padrões de projeto excessivamente complexos ou recursos avançados do Java que fujam desse escopo. O foco é manter o código funcional, limpo e didático.

### 2. Perfil de Desenvolvimento ("Média 6")

* **Estilo Acessível**: O projeto deve ser desenvolvido simulando o nível de alunos de desempenho intermediário (média 6).
* **Legibilidade**: Evitaremos "soluções mágicas" ou linhas de código excessivamente condensadas. É fundamental que qualquer membro do grupo consiga bater o olho, entender o fluxo lógico e explicar a implementação sem dificuldades durante a avaliação.
* **Tudo em portugues do brazil**

### 3. Pastas de Referência no Projeto

Para nortear o estilo de escrita e o nível de complexidade, disponibilizamos duas pastas de consulta obrigatória no diretório do projeto:

* **`material da disciplina de programação 3 - java`**: Contém os limites teóricos e práticos de sintaxe, estruturas de dados e conceitos que dominamos.
* **`nossa forma de programação`**: Apresenta exemplos práticos do nosso estilo real de codificação, servindo de gabarito para manter a escrita do código padronizada.

---

A saida geral deve está em uma pasta chamada "Trabalho-TC-main" nos molde do projeto base.