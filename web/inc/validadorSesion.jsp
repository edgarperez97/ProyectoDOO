<%-- 
    Document   : validadorSesion
    Created on : 30/03/2018, 12:40:19 AM
    Author     : edgar
--%>

<%@page import="ModelosDTO.UsuarioDTO"%>
<%
    request.getSession();
    UsuarioDTO usu = (UsuarioDTO) session.getAttribute("usuario");

    if (usu == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>