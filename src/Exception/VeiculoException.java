/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Jean
 */
public class VeiculoException extends Exception{
    private static final long serialVersionUID = 1L;
    
    public VeiculoException(){
        super("Veiculo exception");
    }    
    
    public VeiculoException(String message) {
        super(message);
    }        
}
