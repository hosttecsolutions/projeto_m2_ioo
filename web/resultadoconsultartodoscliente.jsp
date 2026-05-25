<%-- 
    Document   : resultadoconsultartodoscliente
    Created on : 25/05/2026
    Author     : luiznicolau
--%>

<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Todos os Clientes</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>

    <body>
        <div class="container-tabela">
            <h1>Clientes Cadastrados</h1>

            <%
                List<Cliente> lcli = (List<Cliente>) request.getAttribute("lcli");
            %>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Data Nascimento</th>
                    <th>Status</th>
                    <th>CEP</th>
                </tr>

                <%
                    if (lcli != null) {
                        for (Cliente c : lcli) {
                %>

                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getNome() %></td>
                    <td><%= c.getCpf() %></td>
                    <td><%= c.getEmail() %></td>
                    <td><%= c.getTelefone() %></td>
                    <td><%= c.getEndereco() %></td>
                    <td><%= c.getCidade() %></td>
                    <td><%= c.getEstado() %></td>
                    <td><%= c.getDataNascimento() %></td>
                    <td><%= c.getStatus() %></td>
                    <td><%= c.getCep() %></td>
                </tr>

                <%
                        }
                    }
                %>
            </table>

            <a href="index.html">Voltar para o início</a>
        </div>
    </body>
</html>