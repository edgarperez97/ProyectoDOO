<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="./img/icon.png">
        <link rel="stylesheet" type="text/css" href="./styles/index.css">
        <script type="text/javascript" language="javascript"  src="./scripts/scripts.js"></script>
        <script type="text/javascript" language="javascript" src="./scripts/validacion.js"></script>
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <form class="form" id="formNU" action="NuevoUsuarioServlet" method="POST" onsubmit="return validarFormularioNU()"|>
            <img src="./img/men.png">

            <div class="field name">
                <div class="icon"></div>
                <input class="input" id="name" type="text" name="txt-name" placeholder="Nombre" autocomplete="off"/>
            </div>

            <div class="field email">
                <div class="icon"></div>
                <input class="input" id="email" type="text" name="txt-email" placeholder="Email" autocomplete="off"/>
            </div>

            <div class="field password">
                <div class="icon"></div>
                <input class="input" id="password" type="password" name="txt-password" placeholder="Contraseña" autocomplete="off"/>
            </div>

            <div class="field phone">
                <div class="icon"></div>
                <input class="input" id="phone" type="text" name="txt-phone" placeholder="Telefono" autocomplete="off"/>
            </div>
            
            <button class="button" name="btnNewUser">Registrar</button>
            <br><center><a href="index.jsp"><i>Regresar</i></a></center>
            
        </form>
    </body>
</html>