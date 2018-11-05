package Prueba;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author edgar
 */
public class PruebaDAO {

    public static void main(String[] args) {

        String pass = "hola";

        String passEncriptado = DigestUtils.md5Hex(pass);

        System.out.println(pass);
        System.out.println(passEncriptado);

    }

}
