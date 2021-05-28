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

        <s:if test="%{#session.rol == 'Gerente'}">

            <table border="1">
                <thead>
                <th>Nick</th>
                <th>Nombre</th>
                <th>Contraseña</th>
                <th>Rol</th>
                <th>¿Modificar?</th>
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
                            <s:form action="updateUsuarioRedirect">
                                <s:hidden name="oculto" value="%{nick}"></s:hidden>
                                <s:submit name="update" value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="deleteUsuario">
                                <s:hidden name="oculto" value="%{nick}"></s:hidden>
                                <s:submit name="delete" value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
        <s:form action="addUsuarioRedirect">
            <s:submit name="add" value="Añadir"></s:submit>
        </s:form>
    </s:if><s:else>

        <table border="1">
            <thead>
            <th>Nick</th>
            <th>Nombre</th>
            <th>Contraseña</th>
            <th>Rol</th>
            <th>¿Modificar?</th>
        </thead>
        <tbody>
            <s:iterator value="listaUsuarios">
                <s:if test="%{nick == #session.nick}">
                    <tr>
                        <td><s:property value="%{nick}"></s:property></td>
                        <td><s:property value="%{nombre}"></s:property></td>
                        <td><s:property value="%{password}"></s:property></td>
                        <td><s:property value="%{rol}"></s:property></td>
                            <td>
                            <s:form action="updateUsuario">
                                <s:hidden name="oculto" value="%{nick}"></s:hidden>
                                <s:submit name="delete" value="Modificar"></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </s:if>
            </s:iterator>
        </tbody>
    </table>
</s:else>

</body>
</html>