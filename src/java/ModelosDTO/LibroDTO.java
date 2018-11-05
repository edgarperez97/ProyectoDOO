package ModelosDTO;

/**
 *
 * @author edgar
 */
public class LibroDTO {

    private int id_Libro;
    private int id_Usuario;
    private String nombreLibro;
    private String nombreAutor;
    private String ISBN;
    private int cantidad;

    //constructor para crear un nuevo libro
    public LibroDTO(int id_Usuario, String nombreLibro, String nombreAutor, String ISBN, int cantidad) {
        this.id_Usuario = id_Usuario;
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.ISBN = ISBN;
        this.cantidad = cantidad;
    }

    //Constructor para modificar un libro
    public LibroDTO(int id_Libro, String nombreLibro, String nombreAutor, int cantidad) {
        this.id_Libro = id_Libro;
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.cantidad = cantidad;
    }
    
    //constructor para mostrar en el jsp
    public LibroDTO(int id_Libro, int id_Usuario, String nombreLibro, String nombreAutor, String ISBN, int cantidad) {
        this.id_Libro = id_Libro;
        this.id_Usuario = id_Usuario;
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.ISBN = ISBN;
        this.cantidad = cantidad;
    }

    public int getId_Libro() {
        return id_Libro;
    }

    public void setId_Libro(int id_Libro) {
        this.id_Libro = id_Libro;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
