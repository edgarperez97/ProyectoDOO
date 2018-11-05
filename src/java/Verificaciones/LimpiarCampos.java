package Verificaciones;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author edgar
 */
public class LimpiarCampos {

    public static String limpiar(String cuerpoHTML) {
        
        String campo = Jsoup.clean(cuerpoHTML, Whitelist.none());
        
        return campo;
    }
}
