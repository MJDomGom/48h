<%-- 
    Document   : addEstadisticas
    Created on : 04-may-2021, 16:32:52
    Author     : mjdom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Añadir Estadisticas</h1>

        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:form action="addEstadistica">
            <s:textfield type="number" min="1" name="partido" label="ID Partido"></s:textfield>
            <s:textfield name="golesTot" label="Resultado(L-V)"></s:textfield>
            <s:textfield name="tirosPuerta" label="Tiros a puerta(L-V)"></s:textfield>
            <s:textfield name="amarillas" label="Amarillas(L-V)"></s:textfield>
            <s:textfield name="rojas" label="Rojas(L-V)"></s:textfield>
            <s:textfield name="azules" label="Azules(L-V)"></s:textfield>

            <s:submit name = "btnAdd" value="Añadir"></s:submit>
        </s:form>   
    </body>
</html>
