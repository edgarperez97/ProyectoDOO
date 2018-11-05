package Controladores;

import static Verificaciones.LimpiarCampos.limpiar;
import Verificaciones.AutenticacionCampos;
import Verificaciones.VerificacionBDLogin;
import ModelosDTO.UsuarioDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author edgar
 */
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameterValues("btnLogin") != null) {

            String txtNombre = limpiar(request.getParameter("txt-nombre"));
            String txtPassword = limpiar(request.getParameter("txt-password"));

            boolean noNumero = AutenticacionCampos.esNumero(txtNombre);
            if (!noNumero) {
                String passEncriptado = DigestUtils.md5Hex(txtPassword);

                //User: Elu    pass: hola
                boolean usuarioValido = VerificacionBDLogin.autenticar(txtNombre, passEncriptado);

                if (usuarioValido) {

                    UsuarioDTO u = new UsuarioDTO(txtNombre, passEncriptado);
                    HttpSession session = request.getSession();

                    session.setAttribute("usuario", u);
                    response.sendRedirect("home.jsp");

                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }

        } else {

            HttpSession session = request.getSession();
            session.removeAttribute("usuario");
            session.invalidate();
            response.sendRedirect("index.jsp");

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
