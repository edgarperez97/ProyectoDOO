package Controladores;

import static Verificaciones.LimpiarCampos.limpiar;
import Verificaciones.AutenticacionCampos;
import DAO.LibroDAOImpl;
import ModelosDTO.LibroDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class ControladorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnAlta") != null) {

            String nombreL = limpiar(request.getParameter("nombreLibro"));
            String nombreA = limpiar(request.getParameter("nombreAutor"));
            String isbn = limpiar(request.getParameter("isbn"));
            int cant = Integer.parseInt(limpiar(request.getParameter("cantidadLibros")));
            int idUsu = Integer.parseInt(limpiar(request.getParameter("idUsuario")));

            boolean noNum = AutenticacionCampos.esNumero(nombreA);
            boolean noNum2 = AutenticacionCampos.esNumero(nombreL);

            if (!noNum && !noNum2) {
                LibroDAOImpl lib = new LibroDAOImpl();
                lib.crear(new LibroDTO(idUsu, nombreL, nombreA, isbn, cant));

                request.getRequestDispatcher("show.jsp").forward(request, response);
            }else{
                response.sendRedirect("home.jsp");
            }

        } else if (request.getParameter("btnEdicion") != null) {

            String nombreL = limpiar(request.getParameter("nombreLibro"));
            String nombreA = limpiar(request.getParameter("nombreAutor"));
            int cant = Integer.parseInt(limpiar(request.getParameter("cantidadLibros")));
            int idLib = Integer.parseInt(limpiar(request.getParameter("idLibro")));

            boolean noNum = AutenticacionCampos.esNumero(nombreA);
            boolean noNum2 = AutenticacionCampos.esNumero(nombreL);

            if (!noNum && !noNum2) {
                LibroDAOImpl lib = new LibroDAOImpl();
                lib.actualizar(new LibroDTO(idLib, nombreL, nombreA, cant));
            }else{
                response.sendRedirect("home.jsp");
            }

            request.getRequestDispatcher("show.jsp").forward(request, response);

        } else if (request.getParameter("btnEliminar") != null) {

            int key = Integer.parseInt(limpiar(request.getParameter("idLibro")));

            LibroDAOImpl lib = new LibroDAOImpl();
            lib.borrar(key);

            request.getRequestDispatcher("show.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
