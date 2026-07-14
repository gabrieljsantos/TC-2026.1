### 1. Modelo de Entrada e Persistência (Padrão JFLAP)

* **Formato de Arquivo (`.jff`)**: O projeto utiliza a especificação XML padrão do software JFLAP para a importação e exportação de dados. Esse arquivo define de forma estruturada os estados, suas coordenadas de exibição (tags `<x>` e `<y>`), as transições e as propriedades de aceitação.
* **Mecanismo de Carregamento**: O sistema contém um módulo de leitura de arquivos estruturado para fazer o *parsing* do XML contido no `.jff`, mapeando as tags para as respectivas instâncias de classes em memória de forma transparente.

### 2. Classes e Camadas do Projeto em Memória (Estrutura do Drive)

A arquitetura do código-fonte está dividida nos seguintes pacotes e diretórios estruturais:

* **`src`**: Diretório raiz do código-fonte onde se concentra toda a lógica de execução e a separação dos pacotes.
* **`entities`**: Pacote responsável por armazenar as classes de dados fundamentais para a representação do autômato na memória. Ele define as estruturas internas para:
* **Autômato**: Classe que atua como o grafo principal, agrupando o conjunto de estados e transições.
* **Estado**: Representação de cada nó do autômato (possuindo identificadores, nome, e flags booleanas para indicar se o estado é inicial ou final).
* **Transição**: Classe que mapeia a origem, o destino e o caractere consumido (ou transição vazia/$\epsilon$) durante a mudança de estado.


* **`enums`**: Contém as enumerações estruturadas do sistema que padronizam definições globais, como os tipos específicos de autômatos manipulados (por exemplo, diferenciando AFD de AFN).
* **`gui`**: Módulo que abriga a interface gráfica do programa, responsável pela interação visual com o usuário, seleção e carregamento de arquivos do disco.
* **`.idea`**: Diretório que contém as definições de ambiente e metadados de configuração do projeto estruturado na IDE IntelliJ IDEA.