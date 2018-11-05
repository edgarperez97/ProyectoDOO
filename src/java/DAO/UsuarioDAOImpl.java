package DAO;

import Conexion.Conexion;
import Interfaces.Metodos;
import ModelosDTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar
 */
public class UsuarioDAOImpl implements Metodos<UsuarioDTO> {

    private final String SQL_CREAR
            = "INSERT INTO usuario (nombre, password, correo, telefono) VALUES (?,?,?,?)";
    private final String SQL_ACTUALIZAR
            = "UPDATE usuario SET correo = ?, telefono = ? WHERE nombre = ?";
    private final String SQL_ELIMINAR
            = "DELETE FROM usuario WHERE id_Usuario = ?";

    private static final Conexion con = Conexion.getInstance();

    @Override
    public boolean crear(UsuarioDTO c) {

        PreparedStatement ps = null;

        try {
            ps = con.getConexion().prepareStatement(SQL_CREAR);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getCorreo());
            ps.setInt(4, c.getTelefono());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            con.cerrarConexion();

            try {
                if (ps != null)ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean borrar(Object key) {

        PreparedStatement ps = null;

        try {

            ps = con.getConexion().prepareStatement(SQL_ELIMINAR);
            ps.setInt(1, key.hashCode());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
            try {
                if (ps != null)ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    @Override
    public boolean actualizar(UsuarioDTO c) {
        PreparedStatement ps = null;
        
        try {
            ps = con.getConexion().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1, c.getCorreo());
            ps.setInt(2, c.getTelefono());
            ps.setString(3, c.getNombre());
            
            if(ps.executeUpdate()>0)return true;
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            con.cerrarConexion();
            try {
                if(ps!= null)ps.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        return false;
    }

    @Override
    public UsuarioDTO leer(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDTO> leerTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
