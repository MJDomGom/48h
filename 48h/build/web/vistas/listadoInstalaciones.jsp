<%-- 
    Document   : listadoInstalaciones
    Created on : 03-may-2021, 18:24:03
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
        <h1>Listado Instalaciones</h1>

        <table border="1">
            <thead>
            <th>ID</th>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Capacidad</th>
            <th>¿Borrar?</th>
        </thead>
        <tbody>
            <s:iterator value="listaInstalaciones" >
                <tr>
                    <td><s:property value="%{id}"></s:property></td>
                    <td><s:property value="%{nombre}"></s:property></td>
                    <td><s:property value="%{direccion}"></s:property></td>
                    <td><s:property value="%{capacidad}"></s:property></td>
                    <td>
                        <s:form action="deleteInstalaciones">
                            <s:hidden name="oculto" value="%{id}"></s:hidden>
                            <s:submit name="delete" value="Borrar"></s:submit>
                        </s:form>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
