<%@include file='inc/validadorSesion.jsp' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="./img/icon.png">
        <title>Home</title>
        <link rel="stylesheet" href="./styles/credits.css">

    </head>
    <body>
        <header id="main-header">
            <a id="logo-header" href="show.jsp">
                <span class="site-name">Almacen Libros</span>
                <span class="site-desc">Clase de Diseño Orientado a Objetos</span>
            </a> 
            <img src="./img/icon.png" height="90px">
            <!-- / #logo-header -->
            <nav>
                <ul>
                    <li><span class="site-name" style="color: whitesmoke">Bienvenido <%= usu.getNombre()%></span></li>
                    <li><a style="color: whitesmoke" href="LoginServlet">Cerrar Sesión</a></li>
                </ul>
            </nav><!-- / nav -->
        </header><!-- / #main-header -->
        <h1><i><center>Creditos</center></i></h1>
    <center>
        <table border="1px">
            <tr>
                <th>Nombre</th>
                <th>Puesto</th>
                <th>Descripción</th>
            </tr>
            <tr>
                <th>Edgar Pérez</th>
                <td>Programador</td>
                <td>Encargado de Programar toda la parte de Servidor asi como de implementar y mejorar la base de datos
                de la aplicación. Técnico Desarrollador de Software por la FIME y actual estudiante de LSTI.</td>
            </tr>
            <tr>
                <th>Alejandro de la Torre</th>
                <td>Diseñador</td>
                <td>Diseñador de la parte visual de la app así mismo de los scrips, encargado de estructurar la base de datos
                . Tecnico en sistemas computacionales y encargado del área de redes de la FARQ en la UANL.</td>
            </tr>
        </table>
    </center>



    <!-- <footer id="main-footer">
        <p>Creditos</p>
        <p>&copy; 2018 <a> - Derechos Resevados</a></p>
    </footer> <!-- / #main-footer -->
</body>
</html>

