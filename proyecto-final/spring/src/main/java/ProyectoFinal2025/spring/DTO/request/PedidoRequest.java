package ProyectoFinal2025.spring.DTO.request;

import java.util.ArrayList;

public class PedidoRequest {
    public ArrayList<LineaPedidoRequest> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaPedidoRequest> lineas) {
        this.lineas = lineas;
    }

    private ArrayList<LineaPedidoRequest> lineas;
}
