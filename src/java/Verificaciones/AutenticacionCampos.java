package Verificaciones;

/**
 *
 * @author edgar
 */
public class AutenticacionCampos {

    public static boolean esNumero(String cadena) {

        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isDigit(cadena.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}
