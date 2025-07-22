package ProyectoFinal2025.spring.exceptions;

public class PedidoNoExisteException extends RuntimeException {
    public PedidoNoExisteException(String message) {
        super(message);
    }
}
