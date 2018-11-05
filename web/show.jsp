<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="inc/validadorSesion.jsp" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="ModelosDTO.LibroDTO" %>
<%@page import="DAO.LibroDAOImpl" %>


<%    
    LibroDAOImpl libroDao = new LibroDAOImpl();
    List<LibroDTO> datos = new ArrayList();
%>


<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="./img/icon.png">
        <title>Home</title>
        <link rel="stylesheet" href="./styles/show.css">
        <script type="text/javascript" src="./scripts/scripts.js"></script>
    </head>
    <body onload="MM_showHideLayers('mision', '', 'show', 'alta', '', 'hide', 'edicion', '', 'hide', 'eliminar', '', 'hide')">
        <header id="main-header">
            <a id="logo-header" href="home.jsp">
                <span class="site-name">Almacen Libros</span>
                <span class="site-desc">Clase de Diseño Orientado a Objetos</span>
            </a> 
            <img src="./img/icon.png" height="90px">
            <!-- / #logo-header -->
            <nav>
                <ul>
                    <li><span class="site-name" style="color: whitesmoke">Bienvenido <%= usu.getNombre() %></span></li>
                    <li><a style="color: whitesmoke" href="#" onclick="MM_showHideLayers('mision', '', 'show', 'alta', '', 'show', 'edicion', '', 'hide', 'eliminar', '', 'hide')">Alta</a></li>
                    <li><a style="color: whitesmoke" href="#" onclick="MM_showHideLayers('mision', '', 'show', 'alta', '', 'hide', 'edicion', '', 'show', 'eliminar', '', 'hide')">Edicion</a></li>
                    <li><a style="color: whitesmoke" href="#" onclick="MM_showHideLayers('mision', '', 'show', 'alta', '', 'hide', 'edicion', '', 'hide', 'eliminar', '', 'show')">Eliminar</a></li>
                    <li><a style="color: whitesmoke" href="LoginServlet">Cerrar Sesión</a></li>
                </ul>
            </nav><!-- / nav -->
        </header><!-- / #main-header -->

    <center>
        <table border="1px">
            <caption>Listra de libros registrados</caption>
            <tr>
                <th>ID Libro</th>
                <th>IdUsuario</th>
                <th>Nombre Libro</th>
                <th>Autor</th>
                <th>Cantidad</th>
                <th>ISBN</th>
            </tr>

            <%
                datos = libroDao.leerTodo();
                for (LibroDTO l : datos) {
            %>
            <tr>
                <td><%= l.getId_Libro() %></td>
                <td><%= l.getId_Usuario()%></td>
                <td><%= l.getNombreLibro()%></td>
                <td><%= l.getNombreAutor()%></td>
                <td><%= l.getCantidad()%></td>
                <td><%= l.getISBN() %></td>
            </tr>
            <%
                }
            %>

        </table>
    </center>

    <section id="alta">
        <article>
            <div class="content">
                <h2 ><i><center>Alta</center></i></h2>
                <p> 
                <form action="ControladorServlet" method="POST">
                    <label>Id Usuario: </label><br>
                    <input type="text" name="idUsuario" autocomplete="off"><br>
                    <label>Titulo: </label><br>
                    <input type="text" name="nombreLibro" autocomplete="off"><br>
                    <label>Nombre Autor:</label><br>
                    <input type="text" name="nombreAutor" autocomplete="off"><br>
                    <label>Cantidad: </label><br>
                    <input type="text" name="cantidadLibros" autocomplete="off"><br>
                    <label>ISBN </label><br>
                    <input type="text" name="isbn" autocomplete="off"><br><br>

                    <%--<input type="file" name="imagenPortada" 
                           accept=".jpg, .jpeg, .png"><br><br>--%>

                    <input type="submit" name="btnAlta" value="enviar">
                </form>
                </p>
            </div>
        </article> 
    </section>
    <section id="edicion">
        <article>
            <div class="content">
                <h2><i><center>Edicion</center></i></h2>
                <p> 
                <form action="ControladorServlet" method="POST">
                    <label>Nuevo Autor: </label><br>
                    <input type="text" name="nombreAutor" autocomplete="off"><br>
                    <label>Nuevo Título: </label><br>
                    <input type="text" name="nombreLibro" autocomplete="off"><br>
                    <label>Nueva Cantidad: </label><br>
                    <input type="text" name="cantidadLibros" autocomplete="off"><br>
                    <label>ID Libro:</label><br>
                    <input type="text" name="idLibro" autocomplete="off"><br><br>

                    <input type="submit" name="btnEdicion" value="enviar">
                </form>
                </p>
            </div>
        </article>
    </section>
    <section id="eliminar">
        <article>
            <div class="content">
                <h2><i><center>Eliminar</center></i></h2>
                <p>
                <form action="ControladorServlet" method="POST">
                    <label>ID Libro: </label><br>
                    <input type="text" name="idLibro" autocomplete="off"><br><br>

                    <input type="submit" name="btnEliminar" value="enviar">
                </form>
                </p>
            </div>
        </article>
    </section>

    <footer id="main-footer">
        <p><a href="creditos.jsp"> Creditos </a></p>
        <p>&copy; 2018 <a> - Derechos Resevados</a></p>
    </footer> <!-- / #main-footer -->
</body>
</html>