package Exception;

public class AnoVeiculoException extends Exception{
    private static final long serialVersionUID = 1L;
    
    @Override
    public String getMessage() {
        return "Ano Inválido";
    }
}
