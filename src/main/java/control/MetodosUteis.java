/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author gudeck
 */
public class MetodosUteis {

    private static String padrao = "dd/MM/yyyy";

    private MetodosUteis() {
        // Classe com métodos abstratos, não precisa ser instanciada.
    }
    
    public static java.sql.Date stringTOsqlDate(String data) throws ParseException {
        SimpleDateFormat formatPattern = new SimpleDateFormat(padrao);
        java.util.Date javaDate = formatPattern.parse(data);

        return new java.sql.Date(javaDate.getTime());
    }

    public static java.util.Date stringTOjavaDate(String data) throws ParseException {
        SimpleDateFormat formatPattern = new SimpleDateFormat(padrao);

        return formatPattern.parse(data);
    }

    public static java.sql.Date javaDateTOsqlDate(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }

    public static String javaDateTOstring(java.util.Date data) {

        SimpleDateFormat formatPattern = new SimpleDateFormat(padrao);
        return formatPattern.format(data);
    }

}
