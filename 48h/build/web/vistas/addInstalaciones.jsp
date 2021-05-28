<%-- 
    Document   : addInstalaciones
    Created on : 03-may-2021, 18:24:39
    Author     : fedev
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
        <h1>Añadir Instalaciones</h1>

        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:form action="addInstalacion">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="direccion" label="Direccion"></s:textfield>
            <s:textfield name="capacidad" type="number" min="0" label="Capacidad"></s:textfield>
            <s:submit name = "btnAdd" value="Añadir"></s:submit>
        </s:form>
    </body>
</html>
