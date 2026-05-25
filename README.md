# Projeto M2 - Implementação Orientada a Objetos

Este projeto foi desenvolvido como atividade de estudo do 3º semestre do curso de Engenharia de Software da UMC, na disciplina de Implementação Orientada a Objetos.

Professor: Pedro de Toledo

Aluno: Luiz Nicolau

Ano: 2026

## Sobre o projeto

O objetivo deste projeto é criar uma aplicação Web em Java para realizar operações de CRUD em uma entidade fictícia de informação.

A entidade escolhida para o sistema foi:

Cliente

O sistema permite realizar as seguintes operações:

- Cadastrar cliente
- Deletar cliente
- Atualizar cliente
- Consultar cliente pelo ID
- Consultar todos os clientes cadastrados

## Entidade Cliente

A entidade Cliente possui os seguintes atributos:

```text
id
nome
cpf
email
telefone
endereco
cidade
estado
dataNascimento
status
cep
```

A tabela no banco de dados foi criada com mais de 10 atributos, conforme solicitado no roteiro do projeto.

O campo status é apresentado no formulário por meio de uma lista de seleção com as opções:

```text
Ativado
Desativado
```

## Tecnologias utilizadas

- Java
- Servlet
- JSP
- HTML
- CSS
- JavaScript
- MySQL
- JDBC
- Apache Tomcat
- NetBeans

## Organização Web

A parte Web do projeto foi organizada separando estrutura, estilo e validação:

```text
index.html
css/estilo.css
js/validacao.js
```

Essa organização mantém o HTML responsável pela estrutura da página, o CSS responsável pela aparência visual e o JavaScript responsável pela validação simples do formulário.

## Páginas do sistema

As principais páginas do projeto são:

```text
index.html
resultado.jsp
erro.jsp
resultadoconsultartodoscliente.jsp
resultadoconsultarbyidcliente.jsp
resultadoconsultaratualizarcliente.jsp
```

O arquivo `index.html` é a tela principal do sistema, onde o usuário informa os dados do cliente e escolhe a operação desejada.

As páginas JSP são responsáveis por exibir os resultados das operações realizadas.

## Padrão MVC

O projeto segue a estrutura MVC.

### Model

Representa a entidade principal do sistema.

```text
Cliente.java
```

A classe Cliente possui os atributos da entidade, construtor vazio, construtor com parâmetros, métodos getters e setters.

### View

Responsável pelas telas da aplicação.

```text
index.html
resultado.jsp
erro.jsp
resultadoconsultartodoscliente.jsp
resultadoconsultarbyidcliente.jsp
resultadoconsultaratualizarcliente.jsp
```

### Controller

Responsável por receber as requisições da View, identificar a operação solicitada e chamar os métodos corretos do DAO.

```text
controle_cliente.java
```

O controller recebe o valor do botão clicado através do parâmetro `op`.

Exemplo:

```text
Cadastrar
Deletar
Atualizar
Consultar pelo ID
Consultar todos
Efetivar atualização
```

## Padrão DAO

O acesso ao banco de dados foi separado em uma classe DAO.

```text
ClienteDAO.java
```

Essa classe contém os métodos responsáveis por:

```text
cadastrar
deletar
atualizar
consultarById
consultarTodos
```

O uso do DAO ajuda a separar a regra de acesso ao banco de dados do restante do sistema.

## Banco de dados

Banco utilizado:

```text
projeto_m2_ioo
```

Tabela principal:

```text
clientes
```

Exemplo de criação da tabela:

```sql
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(150),
    cidade VARCHAR(80),
    estado VARCHAR(2),
    data_nascimento DATE,
    status VARCHAR(20),
    cep VARCHAR(20)
);
```

## Explicação dos tipos usados no banco

Os campos CPF, telefone e CEP foram definidos como VARCHAR porque não são usados para cálculos matemáticos.

Além disso, esses campos podem conter caracteres como ponto, traço, parênteses e zero no início.

Exemplos:

```text
CPF: 123.456.789-00
Telefone: (11) 99999-9999
CEP: 08700-000
```

O campo data_nascimento foi definido como DATE porque representa uma data real.

## Conexão com o banco

A conexão com o banco de dados é feita pela classe:

```text
Conexao.java
```

A conexão utiliza JDBC com o driver:

```text
mysql-connector-j-9.2.0.jar
```

A URL de conexão aponta para o banco:

```text
jdbc:mysql://localhost:3306/projeto_m2_ioo
```

## Segurança e combate a SQL Injection

O projeto utiliza PreparedStatement nas operações do DAO.

Isso evita a montagem direta de comandos SQL por concatenação de texto.

Exemplo correto usado no projeto:

```java
PreparedStatement comando = con.prepareStatement(
    "select * from clientes where id = ?"
);

comando.setInt(1, c.getId());
```

Com isso, os dados digitados pelo usuário são tratados como valores e não como parte do comando SQL.

Essa prática ajuda no combate a SQL Injection.

## Validação com JavaScript

O projeto possui uma validação simples no arquivo:

```text
js/validacao.js
```

Essa validação verifica se os campos principais foram preenchidos antes do cadastro.

Campos validados:

```text
Nome
CPF
Email
```

## Separação do CSS

O CSS foi separado no arquivo:

```text
css/estilo.css
```

Assim, o HTML e os JSPs ficam responsáveis pela estrutura das páginas, enquanto o CSS concentra a aparência visual do sistema.

Isso melhora a organização do projeto e evita repetição de estilos dentro das páginas.

## Fluxo das operações

### Cadastrar cliente

1. O usuário preenche os dados no formulário.
2. Clica no botão CADASTRAR.
3. O formulário envia os dados para o controle_cliente.
4. O controller cria um objeto Cliente.
5. O controller chama o método cadastrar do ClienteDAO.
6. O DAO executa o INSERT no banco.
7. A página resultado.jsp mostra a mensagem de sucesso.

### Consultar cliente pelo ID

1. O usuário informa o ID.
2. Clica em CONSULTAR PELO ID.
3. O controller chama o método consultarById do ClienteDAO.
4. O DAO executa SELECT com WHERE id = ?.
5. A página resultadoconsultarbyidcliente.jsp mostra os dados do cliente encontrado.

### Consultar todos os clientes

1. O usuário clica em CONSULTAR TODOS.
2. O controller chama o método consultarTodos do ClienteDAO.
3. O DAO executa SELECT * FROM clientes.
4. O resultado é colocado em uma lista de clientes.
5. A página resultadoconsultartodoscliente.jsp exibe os dados em uma tabela.

### Atualizar cliente

1. O usuário informa o ID.
2. Clica em ATUALIZAR.
3. O controller busca o cliente pelo ID.
4. A página resultadoconsultaratualizarcliente.jsp abre com os dados preenchidos.
5. O usuário altera os dados.
6. Clica em EFETIVAR ATUALIZAÇÃO.
7. O controller chama o método atualizar do ClienteDAO.
8. O DAO executa UPDATE no banco.
9. A página resultado.jsp mostra a mensagem de sucesso.

### Deletar cliente

1. O usuário informa o ID.
2. Clica em DELETAR.
3. O controller chama o método deletar do ClienteDAO.
4. O DAO executa DELETE FROM clientes WHERE id = ?.
5. Depois o sistema consulta todos os clientes novamente.
6. A página resultadoconsultartodoscliente.jsp mostra a lista atualizada.

## Arquivos principais do projeto

```text
src/java/model/Cliente.java
src/java/DAO/ClienteDAO.java
src/java/controller/controle_cliente.java
src/java/util/Conexao.java

web/index.html
web/css/estilo.css
web/js/validacao.js
web/resultado.jsp
web/erro.jsp
web/resultadoconsultartodoscliente.jsp
web/resultadoconsultarbyidcliente.jsp
web/resultadoconsultaratualizarcliente.jsp
```

## Observações

Este projeto foi desenvolvido com fins acadêmicos, seguindo a estrutura e os conceitos estudados em aula, com foco em:

- Programação Orientada a Objetos
- Encapsulamento
- Classes, atributos, métodos e objetos
- MVC
- DAO
- CRUD com banco de dados MySQL
- Aplicação Web com Java
- Separação básica entre HTML, CSS e JavaScript
- Uso de PreparedStatement para combater SQL Injection
