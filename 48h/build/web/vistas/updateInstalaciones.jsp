<%-- 
    Document   : updateInstalaciones
    Created on : 03-may-2021, 18:25:41
    Author     : fedev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Instalacion</h1>

        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:form action="updateInstalacion">
            <s:textfield name="nombreUpd" label="Nombre" value="%{session.NombreUpd}"></s:textfield>
            <s:textfield name="dirUpd" label="Direccion" value="%{session.DirUpd}"></s:textfield>
            <s:textfield name="capUpd" label = "Capacidad" type="number" min="0" value="%{session.CapUpd}"></s:textfield>
            <s:hidden name="idUpd" value="%{session.IdUpd}"></s:hidden>
            <s:submit name="btnupdate" value="Modificar"></s:submit>
        </s:form>
    </body>
</html>
