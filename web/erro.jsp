<%-- 
    Document   : erro
    Created on : 25/05/2026
    Author     : luiznicolau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Erro</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>

    <body>
        <div class="caixa">
            <%
                String msg = (String) request.getAttribute("message");
            %>

            <h1 class="titulo-erro">Erro ao realizar a operação.</h1>

            <p>Operação: <% out.println(msg); %></p>

            <a href="index.html">Voltar para o início</a>
        </div>
    </body>
</html>