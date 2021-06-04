<%-- 
    Document   : updateIntegrante
    Created on : 04-jun-2021, 0:56:30
    Author     : fedev
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form action="updateIntegrante">  
            <s:hidden name="oculto"></s:hidden>
            <s:textfield name="nombre"  label="Nombre"></s:textfield>
            <s:textfield name="apellidos"  label="Apellidos"></s:textfield>
            <s:textfield name="dorsal" type="number" min="1" max="99" label="Dorsal"></s:textfield>
            <s:select label="Equipo " 
                      headerKey="-1" headerValue="Equipos disponibles"
                      name="equipo"
                      list="listaEquipo"
                      listValue="nombre"
                      value="equipo"
                      />
            <s:submit value="Guardar Cambios"></s:submit>
        </s:form>
    </body>
</html>
