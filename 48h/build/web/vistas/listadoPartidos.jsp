<%-- 
    Document   : listadoPartidos
    Created on : 03-may-2021, 18:23:40
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
        <h1>LISTADO PARTIDOS</h1>
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

        <table border="1">
            <thead>
            <th>Local</th>
            <th>Visitante</th>
            <th>Resultado</th>
            <th>Fecha</th>
            <th>Instalacion</th>
                <s:if test="%{#session.rol == 'Gerente'}">
                <th>¿Borrar?</th>
                </s:if>
        </thead>
        <tbody>
            <s:iterator value="listaPartidos">
                <tr>
                    <td><s:property value="%{local}"></s:property></td>
                    <td><s:property value="%{visitante}"></s:property></td>
                    <td><s:property value="%{resultado}"></s:property></td>
                    <td><s:property value="%{fecha}"></s:property></td>
                    <td><s:property value="listaJuegan"></s:property></td>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <td>
                            <s:form action="deletePartidos">
                                <s:hidden name="oculto" value="%{idPartido}"></s:hidden>
                                <s:submit name="delete" value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </s:if>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <s:if test="%{#session.rol == 'Gerente'}">
        <s:form action="addPartidosRedirect">
            <s:submit name="add" value="Añadir Partidos"></s:submit>
        </s:form>
    </body>
</s:if>
</body>
</html>

