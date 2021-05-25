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
        <h1>Listado Usuarios</h1>

        <table border="1">
            <thead>
            <th>Nick</th>
            <th>Nombre</th>
            <th>Contraseña</th>
            <th>Rol</th>
            <th>¿Borrar?</th>
        </thead>
        <tbody>
            <s:iterator value="listaUsuarios">
                <tr>
                    <td><s:property value="%{nick}"></s:property></td>
                    <td><s:property value="%{nombre}"></s:property></td>
                    <td><s:property value="%{password}"></s:property></td>
                    <td><s:property value="%{rol}"></s:property></td>
                    <td>
                        <s:form action="deleteUsuarios">
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