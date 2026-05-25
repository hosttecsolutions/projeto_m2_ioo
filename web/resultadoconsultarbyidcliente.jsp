<%-- 
    Document   : resultadoconsultarbyidcliente
    Created on : 25/05/2026
    Author     : luiznicolau
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Cliente por ID</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>

    <body>
        <div class="container">
            <h1>Cliente Consultado</h1>

            <%
                Cliente c = (Cliente) request.getAttribute("c");
            %>

            <div class="campo-consulta">
                <p><strong>ID:</strong> <%= c.getId() %></p>
                <p><strong>Nome:</strong> <%= c.getNome() %></p>
                <p><strong>CPF:</strong> <%= c.getCpf() %></p>
                <p><strong>Email:</strong> <%= c.getEmail() %></p>
                <p><strong>Telefone:</strong> <%= c.getTelefone() %></p>
                <p><strong>Endereço:</strong> <%= c.getEndereco() %></p>
                <p><strong>Cidade:</strong> <%= c.getCidade() %></p>
                <p><strong>Estado:</strong> <%= c.getEstado() %></p>
                <p><strong>Data Nascimento:</strong> <%= c.getDataNascimento() %></p>
                <p><strong>Status:</strong> <%= c.getStatus() %></p>
                <p><strong>CEP:</strong> <%= c.getCep() %></p>
            </div>

            <a href="index.html">Voltar para o início</a>
        </div>
    </body>
</html>