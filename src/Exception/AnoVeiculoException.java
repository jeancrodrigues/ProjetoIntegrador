/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Jean
 */
public class AnoVeiculoException extends Exception{
    @Override
    public String getMessage() {
        return "Ano Inválido";
    }
}
