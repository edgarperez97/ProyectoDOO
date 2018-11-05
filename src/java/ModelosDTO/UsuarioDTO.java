package ModelosDTO;

/**
 *
 * @author edgar
 */
public class UsuarioDTO {

    private String nombre;
    private String password;
    private String correo;
    private int telefono;

    //Constructor para verificacion con la BD
    public UsuarioDTO(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    //Constructor para crear un nuevo usuario
    public UsuarioDTO(String nombre, String password, String correo, int telefono) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
