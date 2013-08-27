/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Jean
 */
public class ClienteException extends Exception{
    private static final long serialVersionUID = 1L;
    
    public ClienteException(){
        super("Cliente exception");
    }    
    
    public ClienteException(String message) {
        super(message);
    }        
}
