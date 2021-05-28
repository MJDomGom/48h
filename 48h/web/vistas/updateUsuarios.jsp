<%-- 
    Document   : updateUsuarios
    Created on : 27-may-2021, 19:18:33
    Author     : mjdom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head />
    </head>
    <body>
        <h1>Modificar Usuario</h1>
        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:form action="updateUsuario">
            <s:textfield name="nombreUpd" label="Nombre Usuario" value="%{session.NombreUpd}"></s:textfield>
            <s:textfield name="passUpd" label="Contraseña" value="%{session.PassUpd}"></s:textfield>
            <s:hidden name="rolUpd" value="%{session.RolUpd}"></s:hidden>
            <s:hidden name="nickUpd" value="%{session.NickUpd}"></s:hidden>
            <s:submit name="btnupdate" value="Modificar"></s:submit>
        </s:form>
    </body>
</html>
