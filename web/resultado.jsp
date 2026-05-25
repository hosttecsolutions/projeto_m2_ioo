/**
 *
 * @author luiznicolau
 */


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Resultado</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>

    <body>
        <div class="caixa">
            <%
               String msg = (String) request.getAttribute("message");
            %>

            <h1><% out.println(msg); %> realizado com sucesso.</h1>

            <a href="index.html">Voltar para o início</a>
        </div>
    </body>
</html>