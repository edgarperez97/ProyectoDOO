package Verificaciones;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar
 */
public class VerificacionBDLogin {

    private static final String SQL_CONSULTA = "SELECT * FROM usuario WHERE nombre = ? AND password = ?";
    private static final Conexion con = Conexion.getInstance();

    public static boolean autenticar(String nombre, String password) {

        PreparedStatement pst = null;
        ResultSet res = null;

        try {
            pst = con.getConexion().prepareStatement(SQL_CONSULTA);

            pst.setString(1, nombre);
            pst.setString(2, password);
            res = pst.executeQuery();

            if (res.absolute(1)) {
                return true;
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Error" + e);
            System.out.println("Error en la verificacion Usuario con la BD");
        } finally {
            con.cerrarConexion();
            try {
                if (pst != null) pst.close();
                if (res != null) res.close();
            } catch (SQLException ex) {
                Logger.getLogger(VerificacionBDLogin.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        }

        return false;
    }

}
