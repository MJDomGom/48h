<%-- 
    Document   : updateEquipo
    Created on : 03-may-2021, 18:25:28
    Author     : fedev
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="updateEquipo">
            <s:textfield name="nombre"  label="Nombre Equipo" readonly="true"></s:textfield>
            <s:textfield name="nomCorto" label="Nuevo nombre corto del equipo"></s:textfield>
            <s:submit value="Guardar Cambios"></s:submit>
        </s:form>
    </body>
</html>
