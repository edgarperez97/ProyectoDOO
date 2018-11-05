package Conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar
 */
public class Conexion {

    public static Conexion instance;
    private Connection conexion;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/db_libreria";

    Properties propiedades = new Properties();

    private Conexion() {
        try {
            Class.forName(DRIVER);//Driver
            try {
                try {
                    propiedades.load(new FileInputStream("C:\\Users\\edgar\\Documents\\Workspace\\Java\\DOO\\Proyecto\\Almacen\\web\\WEB-INF\\datos.properties"));
                    //propiedades.load(getClass().getResourceAsStream("/WEB-INF/datos.properties"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    ex.getMessage();
                } catch (IOException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    ex.getMessage();
                }
                
                String PASS = propiedades.getProperty("password");
                String USER = propiedades.getProperty("usuario");
                conexion = DriverManager.getConnection(URL, USER, PASS);
                
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no se pudo establecer la conexion");
            ex.getMessage();
        }
    }

    public synchronized static Conexion getInstance() {

        if (instance == null) {
            instance = new Conexion();
        }

        return instance;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        instance = null;
    }
}
