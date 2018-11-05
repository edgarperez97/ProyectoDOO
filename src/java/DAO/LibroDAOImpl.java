package DAO;

import Conexion.Conexion;
import Interfaces.Metodos;
import ModelosDTO.LibroDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar
 */
public class LibroDAOImpl implements Metodos<LibroDTO> {

    private final String SQL_CREAR
            = "INSERT INTO libro (id_Usuario,nombreLibro,nombreAutor,ISBN,cantidad) VALUES (?,?,?,?,?)";
    private final String SQL_ELIMINAR
            = "DELETE FROM libro WHERE id_Libro = ?";
    private final String SQL_ACTUALIZAR
            = "UPDATE libro SET nombreLibro = ?, nombreAutor = ?, cantidad = ? WHERE id_Libro = ?";
    private final String SQL_LEERPORUSUARIO
            = "SELECT * FROM Libro WHERE id_Usuario = ?";
    private final String SQL_LEERTODO = "SELECT * FROM libro";
    private static final Conexion con = Conexion.getInstance();

    @Override
    public boolean crear(LibroDTO c) {
        PreparedStatement ps = null;
        try {

            ps = con.getConexion().prepareStatement(SQL_CREAR);

            ps.setInt(1, c.getId_Usuario());
            ps.setString(2, c.getNombreLibro());
            ps.setString(3, c.getNombreAutor());
            ps.setString(4, c.getISBN());
            ps.setInt(5, c.getCantidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } finally {
            con.cerrarConexion();
           try {
                if(ps!=null)ps.close();
            } catch (SQLException e) {
                e.getMessage();
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
            Logger.getLogger(LibroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
            try {
                if(ps!=null)ps.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(LibroDTO c) {
        PreparedStatement ps = null;

        try {
            ps = con.getConexion().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1, c.getNombreLibro());
            ps.setString(2, c.getNombreAutor());
            ps.setInt(3, c.getCantidad());
            ps.setInt(4, c.getId_Libro());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
            try {
                if(ps!=null)ps.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }

        return false;
    }

    @Override
    public LibroDTO leer(Object key) {
        LibroDTO lib = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            ps = con.getConexion().prepareStatement(SQL_LEERPORUSUARIO);
            ps.setInt(1, key.hashCode());

            res = ps.executeQuery();

            if(res.next()) {
                lib = new LibroDTO(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
            try {
                if(ps!=null)ps.close();
                if(res!=null)res.close();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("No se pudo cerrar el Prepared Statement ni el Resulset");
            }
        }

        return lib;
    }

    @Override
    public List<LibroDTO> leerTodo() {
        PreparedStatement ps = null;
        ArrayList<LibroDTO> libros = new ArrayList();
        ResultSet res = null;

        try {
            ps = con.getConexion().prepareStatement(SQL_LEERTODO);
            res = ps.executeQuery();

            while (res.next()) {
                libros.add(new LibroDTO(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getInt(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LibroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();

            try {
                if(ps!=null)ps.close();
                if(res!=null)res.close();
            } catch (SQLException e) {
                e.getMessage();
                System.out.println("No se pudo cerrar el Prepared Statement ni el Resulset");
            }
            
        }

        return libros;
    }

}
