
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Listado Instalaciones - 48h</title>

        <%-- FAVICON --%>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/vistas/assets/img/favicon.ico">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="vistas/assets/css/smoothproducts.css">
    </head>
    <body style="background: white;">
        <nav class="navbar navbar-light navbar-expand-lg bg-dark clean-navbar" style="background: #888888; border-color: gray; margin-bottom: 15px;">
            <div class="container">
                <a class="navbar-brand logo" href="#"><img src="vistas/assets/img/Logo-48h.png" style="height: 60px;">
                </a>
                <s:form action="redirectLogout">
                    <s:submit cssClass="btn btn-primary text-light bg-dark border-light" name="logout" value="Cerrar Sesión"></s:submit>
                </s:form>
            </div>
        </nav>
        <main class="page landing-page">
            <section class="clean-block slider dark">
                <div class="container">
                    <div class="block-heading text-center">
                        <h2 class="text-dark shadow">LISTADO DE INSTALACIONES</h2>
                        <div style="margin-top: 25px; margin-bottom: 20px;">
                            <p>Instalaciones disponibles:</p>
                        </div>
                    </div>
                    <table style="margin-top: 10px; margin-bottom: 15px">
                        <th>             
                            <s:form action="redirectUsuario">
                                <s:submit name="usuarios" cssClass="btn btn-primary text-dark bg-light border-dark" value="Usuarios"></s:submit>
                            </s:form>
                        </th>
                    </table>
                    <s:if test="%{#session.rol == 'Gerente'}">
                        <s:form action="addInstalacionesRedirect">
                            <s:submit name="add" cssClass="btn btn-primary text-light bg-dark border-light" value="Añadir"></s:submit>
                        </s:form>
                    </s:if>                    
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="shadow-sm" style="text-align: center;">Nombre</th>
                                    <th class="shadow-sm" style="text-align: center;">Dirección</th>
                                    <th class="shadow-sm" style="text-align: center;">Capacidad</th>
                                        <s:if test="%{#session.rol == 'Gerente'}">
                                        <th class="shadow-sm" style="text-align: center;">Modificar</th>
                                        <th class="shadow-sm" style="text-align: center;">Borrar</th>
                                        </s:if>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaInstalaciones" >
                                    <tr>
                                        <td class="text-center"><s:property value="%{nombre}"/></td>
                                        <td class="text-center"><s:property value="%{direccion}"/></td>
                                        <td class="text-center"><s:property value="%{capacidad}"/></td>
                                        <s:if test="%{#session.rol == 'Gerente'}">
                                            <td style="width: 33px; margin: 0 auto;">
                                                <s:form action="updateInstalacionesRedirect">
                                                    <s:hidden name="oculto" value="%{id}"></s:hidden>
                                                    <s:submit name="delete" cssClass="btn btn-primary text-light bg-dark border-light" value="Modificar"></s:submit>
                                                </s:form>
                                            </td>
                                            <td style="width: 33px; margin: 0 auto;">
                                                <s:form action="deleteInstalaciones">
                                                    <s:hidden name="oculto" value="%{id}"></s:hidden>
                                                    <s:submit name="delete" cssClass="btn btn-danger text-light bg-dark border-light" value="Borrar"></s:submit>
                                                </s:form>
                                            </td>
                                        </s:if>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </main>
        <footer class="page-footer dark  navbar-light navbar-expand-lg fixed-bottom bg-dark " style="background: #888888; border-color: gray; text-align: center; padding-top: 15px;">
            <div class="footer-copyright" style="color: white;">
                <p>© 2021 Torneo 48h.</p>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="vistas/assets/js/smoothproducts.min.js"></script>
        <script src="vistas/assets/js/theme.js"></script>
    </body>
</html>
