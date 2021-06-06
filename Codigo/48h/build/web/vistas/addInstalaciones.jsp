
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Añadir Instalación - 48h</title>

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
            <section class="clean-block slider dark" style="background: rgb(246, 246, 246);">
                <div class="container">
                    <div class="block-heading text-center">
                        <h2 class="text-dark shadow">AÑADIR INSTALACIÓN</h2>
                        <div style="margin-top: 25px; margin-bottom: 20px;">
                            <p>Introduce los datos para registrar una instalación:</p>
                        </div>
                    </div>
                    <section class="text-light d-inline-block float-none d-lg-flex justify-content-lg-center" style="background: rgb(246,246,246); margin-top: 30px; padding-right: 70px;">
                        <div class="form-container">
                            <s:form action="addInstalacion">
                                <div class="form-group"><s:textfield name="nombre" class="form-control" cssStyle="height: 40px; width: 500px; margin: 10px; text-align: center;" label="Nombre" placeholder="Nombre"></s:textfield></div>
                                <div class="form-group"><s:textfield name="direccion" id="direccion" class="form-control" cssStyle="height: 40px; width: 500px; margin: 10px; text-align: center;" label="Direccion" placeholder="Dirección"></s:textfield></div>
                                <div class="form-group"><s:textfield name="ciudad" id="ciudad" class="form-control" cssStyle="height: 40px; width: 500px; margin: 10px; text-align: center;" label="Ciudad" placeholder="Ciudad"></s:textfield></div>
                                <div class="form-group"><s:textfield name="capacidad" class="form-control" cssStyle="height: 40px; width: 500px; margin: 10px; text-align: center;" type="number" min="0" label="Capacidad" placeholder="Capacidad"></s:textfield></div>
                                <s:hidden name="longitud" id="longitud"></s:hidden>
                                <s:hidden name="latitud" id="latitud"></s:hidden>    
                                <s:submit name = "btnAdd" cssStyle="height: 40px; width: 500px; margin: 10px;" cssClass="btn btn-primary btn-block text-light bg-dark border-light" value="Añadir"></s:submit>
                            </s:form>
                            <section class="text-light d-inline-block float-none d-lg-flex justify-content-lg-center" style="background: rgb(246,246,246); padding-right: 220px;">
                                <div class="form-container">
                                    <s:form action="cargarInstalaciones">
                                        <s:submit name = "btnCancelar" value="Cancelar" cssStyle="height: 40px; width: 200px; margin: 10px; margin-bottom: 50px;" cssClass="btn btn-primary btn-block text-light bg-dark border-light"></s:submit>
                                    </s:form>
                                </div>
                            </section>
                        </div>
                    </section>
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

        <%-- API GOOGLE MAPS --%>
        <script type="text/javascript">

            $(document).ready(function () {
                $("#direccion").on("change", geolocate);
                $("#ciudad").on("change", geolocate);
            });

            function geolocate() {
                var ciudad = $("#ciudad").val();
                var direccion = $("#direccion").val();
                $.ajax({
                    type: "get",
                    url: "https://maps.googleapis.com/maps/api/geocode/json?address=" + direccion + "+" + ciudad + "&key=AIzaSyBX1Qy2dFMigK3r7pwgCBFC90exmctPt6g",
                    datatype: "application/json; charset=utf-8",
                    success: function (localizacion) {
                        console.log(localizacion);

                        $("#latitud").val(localizacion.results[0].geometry.location.lat);
                        $("#longitud").val(localizacion.results[0].geometry.location.lng);
                    }
                });
            }
        </script>
    </body>
</html>
