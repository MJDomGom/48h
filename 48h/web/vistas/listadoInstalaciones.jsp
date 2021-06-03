<%-- 
    Document   : listadoInstalaciones
    Created on : 03-may-2021, 18:24:03
    Author     : fedev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado Instalaciones</h1>

        <table>
            <th>             <s:form action="redirectUsuario">
                    <s:submit name="usuarios" value="Usuarios"></s:submit>
                </s:form>
            </th>
        </table>

        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:if test="%{#session.rol == 'Gerente'}">
            <s:form action="addInstalacionesRedirect">
                <s:submit name="add" value="Añadir"></s:submit>
            </s:form>
        </s:if>

        <table border="1">
            <thead>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Capacidad</th>
                <s:if test="%{#session.rol == 'Gerente'}">
                <th>¿Modificar?</th>
                <th>¿Borrar?</th>
                </s:if>
        </thead>
        <tbody>
            <s:iterator value="listaInstalaciones">
                <tr>
                    <td><s:property value="%{nombre}"></s:property></td>
                    <td><s:property value="%{direccion}"></s:property></td>
                    <td><s:property value="%{capacidad}"></s:property></td>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <td>
                            <s:form action="updateInstalacionesRedirect">
                                <s:hidden name="oculto" value="%{id}"></s:hidden>
                                <s:submit name="delete" value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="deleteInstalaciones">
                                <s:hidden name="oculto" value="%{id}"></s:hidden>
                                <s:submit name="delete" value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </s:if>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
