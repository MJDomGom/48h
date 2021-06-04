<%-- 
    Document   : vistaEquipo
    Created on : 03-may-2021, 18:23:50
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
        <h1>Listado Equipos</h1>   
        <table border="1">
            <thead>
            <th>Nombre</th>
            <th>Nombre Corto</th>
                <s:if test="%{#session.rol == 'Gerente'}">
                <th>¿Modificar?</th>
                <th>¿Borrar?</th>
                </s:if>
        </thead>
        <tbody>
            <s:iterator value="listaEquipos">
                <tr>
                    <td><s:property value="%{nombre}"></s:property></td>
                    <td><s:property value="%{nomCorto}"></s:property></td>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <td>
                            <s:form action="updateEquiposRedirect">
                                <s:hidden name="oculto" value="%{nombre}"></s:hidden>
                                <s:submit name="delete" value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="deleteEquipos">
                                <s:hidden name="oculto" value="%{nombre}"></s:hidden>
                                <s:submit name="delete" value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </s:if>
                </tr>
            </s:iterator>
            <s:form action="addEquipoRedirect">
                <s:submit value="Añadir Equipo"></s:submit>
            </s:form>
            </body>
            </html>
