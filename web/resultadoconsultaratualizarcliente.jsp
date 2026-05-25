<%-- 
    Document   : resultadoconsultaratualizarcliente
    Created on : 25/05/2026
    Author     : luiznicolau
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Cliente</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>

    <body>
        <div class="container">
            <h1>Atualizar Cliente</h1>

            <%
                Cliente c = (Cliente) request.getAttribute("c");
            %>

            <form name="f1" action="controle_cliente" method="GET">

                <label>ID:</label>
                <input type="text" name="txtid" value="<%= c.getId() %>" readonly><br>

                <label>Nome:</label>
                <input type="text" name="txtnome" value="<%= c.getNome() %>"><br>

                <label>CPF:</label>
                <input type="text" name="txtcpf" value="<%= c.getCpf() %>"><br>

                <label>Email:</label>
                <input type="email" name="txtemail" value="<%= c.getEmail() %>"><br>

                <label>Telefone:</label>
                <input type="text" name="txttelefone" value="<%= c.getTelefone() %>"><br>

                <label>Endereço:</label>
                <input type="text" name="txtendereco" value="<%= c.getEndereco() %>"><br>

                <label>Cidade:</label>
                <input type="text" name="txtcidade" value="<%= c.getCidade() %>"><br>

                <label>Estado:</label>
                <input type="text" name="txtestado" maxlength="2" value="<%= c.getEstado() %>"><br>

                <label>Data de Nascimento:</label>
                <input type="date" name="txtdataNascimento" value="<%= c.getDataNascimento() %>"><br>

                <label>Status:</label>
                <select name="txtstatus">
                    <option value="Ativado" <%= "Ativado".equals(c.getStatus()) ? "selected" : "" %>>Ativado</option>
                    <option value="Desativado" <%= "Desativado".equals(c.getStatus()) ? "selected" : "" %>>Desativado</option>
                </select><br>

                <label>CEP:</label>
                <input type="text" name="txtcep" value="<%= c.getCep() %>"><br>

                <div class="botoes">
                    <input type="submit" name="op" value="EFETIVAR ATUALIZAÇÃO">
                </div>
            </form>

            <a href="index.html">Voltar para o início</a>
        </div>
    </body>
</html>