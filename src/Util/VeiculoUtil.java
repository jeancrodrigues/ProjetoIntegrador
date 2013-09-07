package Util;

import Exception.AnoVeiculoException;
import java.util.Calendar;

public class VeiculoUtil{
    public static void validaAnoVeiculo(int ano) throws AnoVeiculoException {        
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);        
        int anoMaximoModelo = anoAtual + 1;
        if( ano<1900 || ano > anoMaximoModelo ){
            throw new AnoVeiculoException();
        }        
    }
}
