<%-- 
    Document   : listadoIntegrantes
    Created on : 02-jun-2021, 17:17:47
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
        <table>
            <th>               <s:form action="redirectInstalaciones">
                    <s:submit name="instalaciones" value="Instalaciones"></s:submit>
                </s:form>
            </th>
            <th>             <s:form action="redirectUsuario">
                    <s:submit name="usuarios" value="Usuarios"></s:submit>
                </s:form>
            <th><s:form action="cargarEquipos">
                    <s:submit value="Equipos"></s:submit>
                </s:form></th>
            <th><s:form action="cargarIntegrantes">
                    <s:submit value="Integrantes"></s:submit>
                </s:form></th>
        </table>
        <s:form action="addIntegranteRedirect">
            <s:submit name="integrante" value="Añadir Jugadores"></s:submit>
        </s:form>
        <table>
            <thead>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Dorsal</th>
            <th>Equipo</th>
        </thead>
        <tbody>
            <s:iterator value="listaIntegrante">
                <tr>
                    <td><s:property value="%{dni}"></s:property></td>
                    <td><s:property value="%{nombre}"></s:property></td>
                    <td><s:property value="%{apellidos}"></s:property></td>
                    <td><s:property value="%{dorsal}"></s:property></td>
                    <td><s:property value="%{nombreEquipo}"></s:property></td>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <td>
                            <s:form action="updateIntegranteRedirect">
                                <s:hidden name="oculto" value="%{dni}"></s:hidden>
                                <s:submit name="modificar" value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="deleteIntegrante">
                                <s:hidden name="oculto" value="%{dni}"></s:hidden>
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
