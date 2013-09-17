/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jean
 */
public class DataUtil {
    
    public static Date stringToDate(String data) throws ParseException{        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if ( data!=null && !data.equals("")) {            
            return new Date(df.parse(data).getTime());
        }
        return null;
    }
    
    public static String dateToString(Date dado) {        
        if(dado != null){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
            return df.format(dado).trim();
        }
        return "";
    }
}
