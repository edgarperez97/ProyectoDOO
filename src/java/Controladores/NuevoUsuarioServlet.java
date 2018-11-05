package Controladores;

import static Verificaciones.LimpiarCampos.limpiar;
import Verificaciones.AutenticacionCampos;
import DAO.UsuarioDAOImpl;
import ModelosDTO.UsuarioDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author edgar
 */
public class NuevoUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnNewUser") != null) {

            String nombre = limpiar(request.getParameter("txt-name"));     
            String password = limpiar(request.getParameter("txt-password"));
            String email = limpiar(request.getParameter("txt-email"));
            int telefono = Integer.parseInt(limpiar(request.getParameter("txt-phone")));

            boolean noNum = AutenticacionCampos.esNumero(nombre);

            if (!noNum) {
                String passEncriptado = DigestUtils.md5Hex(password);

                UsuarioDAOImpl usu = new UsuarioDAOImpl();
                usu.crear(new UsuarioDTO(nombre, passEncriptado, email, telefono));
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("newuser.jsp").forward(request, response);
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
