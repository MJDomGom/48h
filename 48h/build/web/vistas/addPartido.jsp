<%-- 
    Document   : addPartido
    Created on : 03-may-2021, 18:25:16
    Author     : fedev
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <sx:head/>
    </head>
    <body>
        <h1>Añadir Partidos</h1>
        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:form action="addPartido">
            <s:textfield name="resultado" label="Resultado(x-x)"></s:textfield>
        
            <s:textfield name="fecha" label="Fecha del partido(dd-MM-yyyy)"></s:textfield>
            <s:checkbox name="equipos" label="Local y Visitante" value="listaEquipos"></s:checkbox>
            <s:submit name = "btnAdd" value="Añadir"></s:submit>
        </s:form>
    </body>
</html>
