<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/icon.png">
        <link rel="stylesheet" type="text/css" href="./styles/index.css">
        <script type="text/javascript" language="javascript" src="./scripts/scripts.js"></script>
        <script type="text/javascript" language="javascript" src="./scripts/validacion.js"></script>
        <title>Login Almacen</title>
    </head>
    <body>
        <form class="form" id="form" action="LoginServlet" method="POST" onsubmit="return validarFormularioLogin();">
            <img src="./img/men.png">

            <div class="field email">
                <div class="icon"></div>
                <input class="input" id="nombre" type="text" name="txt-nombre" placeholder="Nombre" required autocomplete="off"/>
            </div>
            <div class="field password">
                <div class="icon"></div>
                <input class="input" id="password" type="password" name="txt-password" placeholder="Contraseña" required autocomplete="off"/>
            </div>

            <button type="submit" class="button" name="btnLogin">Entrar</button>

            <br><center><a href="newuser.jsp"><i>Agregar nuevo usuario</i></a></center>
        </form>
    </body>
</html>

<!--linear-gradient( rgba(240, 212, 0, 0.45), rgba(0, 0, 0, 0.45) );
    linear-gradient(45deg, #83a4d4, #b6fbff);
-->
