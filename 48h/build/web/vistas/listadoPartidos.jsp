<%-- 
    Document   : listadoPartidos
    Created on : 03-may-2021, 18:23:40
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
        <h1>LISTADO PARTIDOS</h1>

        <s:form action="redirectInstalaciones">
            <s:submit name="instalaciones" value="Instalaciones"></s:submit>
        </s:form>
        <s:form action="redirectUsuario">
            <s:submit name="usuarios" value="Usuarios"></s:submit>
        </s:form>
    </body>
</html>
