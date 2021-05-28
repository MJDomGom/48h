<%-- 
    Document   : addUsuarios
    Created on : 27-may-2021, 19:22:47
    Author     : mjdom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Alta de Usuarios</h1>
        <s:form action="addUsuario">
            <s:textfield name="nick" label="Nick del usuario"></s:textfield>
            <s:textfield name="nombre" label="Nombre del usuario"></s:textfield>
            <s:textfield name="password" label="Contraseña del usuario"></s:textfield>
            <s:submit name = "btnAdd" value="Añadir"></s:submit>
        </s:form>
    </body>
</html>
