<%-- 
    Document   : addEquipo
    Created on : 03-may-2021, 18:24:29
    Author     : fedev
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Añadir Equipo - 48h</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%-- FAVICON --%>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/vistas/assets/img/favicon.ico">

    </head>
    <body>
        <h1>Añadir Equipo</h1>
    <s:form action="addEquipo">
        <s:textfield name="nombre" label="Nombre de equipo"></s:textfield>
        <s:textfield name="nomCorto" label="Nombre Corto"></s:textfield>
        <s:submit value="Guardar Equipo"></s:submit>
    </s:form>
</body>
</html>

