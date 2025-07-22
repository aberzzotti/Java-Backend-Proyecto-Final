package ProyectoFinal2025.spring.exceptions;

public class ProductoNoExisteException extends RuntimeException {
    public ProductoNoExisteException(String message){
        super(message);
    }
}
