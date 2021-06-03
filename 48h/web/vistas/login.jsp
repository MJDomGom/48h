<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Login - 48h</title> 
        <%---- CCS ----%>
        <link href="${pageContext.request.contextPath}/vistas/assets/css/estilo_login.css" rel="stylesheet" type="text/css"/>

        <%-- FAVICON --%>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/vistas/assets/img/favicon.ico">
    </head>
    <body>

        <main>
            <!---- PRINCIPAL: LOGOTIPO Y FORMULARIO ---->
            <div id='ventanaLogin'>

                <!---- LOGO 48H ---->
                <figure><img src="${pageContext.request.contextPath}/vistas/assets/img/Logo-48h.png" alt='logo'/></figure>

                <!---- FORMULARIO DE INICIO DE SESIÓN ---->
                <s:form action="loginCheck" validate="true">

                    <!---- TEXT FIELD DE NOMBRE DE USUARIO ---->
                    <s:fielderror name="login" cssClass="errorForm"/>
                    <div class="inputLogin" id="nick">
                        <s:textfield id='nickTextField' name='nick' value='' placeholder='Nick' >
                        </s:textfield>
                    </div>

                    <!---- TEXT FIELD DE PASSWORD ---->
                    <div class="inputLogin" id="password">
                        <s:password id='contrasenaTextField' name='password' value='' placeholder='Contraseña' >
                        </s:password> <br/>
                    </div>

                    <!---- BOTÓN INICIAR SESIÓN: submit ---->
                    <div id="divIniciarSesion">
                        <s:submit name='iniciarSesion' cssClass="boton" value='Iniciar sesión'>
                        </s:submit>
                    </div>
                </s:form>

                <!---- BOTÓN REGISTRAR: submit ---->
                <s:form action="registrarRedirect">
                    <s:submit type='submit' cssClass="boton" name='registrar' value='Regístrate'>
                    </s:submit>
                </s:form>
            </div>

        </main>

    </body>
</html>
