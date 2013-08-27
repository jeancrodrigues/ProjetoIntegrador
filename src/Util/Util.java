/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Exception.AnoVeiculoException;
import java.util.Calendar;

/**
 *
 * @author Jean
 */
public class Util {

    public static void validaAnoVeiculo(int ano) throws AnoVeiculoException {        
        if( ano<1900 || ano > 2013){
            throw new AnoVeiculoException();
        }        
    }
    
    
    
}
