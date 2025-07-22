package ProyectoFinal2025.spring.exceptions;

public class NoStockException extends RuntimeException {
    public NoStockException(String message){
        super(message);
    }
}
