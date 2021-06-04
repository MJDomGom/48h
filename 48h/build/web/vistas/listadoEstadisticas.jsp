<%-- 
    Document   : listadoEstadisticas
    Created on : 04-may-2021, 16:32:40
    Author     : mjdom
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
        <h1>Listado Estadisticas</h1>

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

        <s:form action="redirectLogout">
            <s:submit name="logout" value="Cerrar Sesion"></s:submit>
        </s:form>

        <s:if test="%{#session.rol == 'Gerente'}">
            <s:form action="addEstadisticasRedirect">
                <s:submit name="add" value="Añadir"></s:submit>
            </s:form>
        </s:if>

        <table border="1">
            <thead>
            <th>ID Partido</th>
            <th>Resultado(L-V)</th>
            <th>Tiros a puerta(L-V)</th>
            <th>Amarillas(L-V)</th>
            <th>Rojas(L-V)</th>
            <th>Azules(L-V)</th>
                <s:if test="%{#session.rol == 'Gerente'}">
                <th>¿Borrar?</th>
                </s:if>
        </thead>
        <tbody>
            <s:iterator value="listaEstadisticas">
                <tr>
                    <td><s:property value="%{partidos}"></s:property></td>
                    <td><s:property value="%{golesTot}"></s:property></td>
                    <td><s:property value="%{tirosPuerta}"></s:property></td>
                    <td><s:property value="%{amarillas}"></s:property></td>
                    <td><s:property value="%{rojas}"></s:property></td>
                    <td><s:property value="%{azules}"></s:property></td>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <td>
                            <s:form action="deleteEstadisticas">
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
