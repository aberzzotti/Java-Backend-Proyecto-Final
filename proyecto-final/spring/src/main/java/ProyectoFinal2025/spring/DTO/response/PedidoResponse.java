package ProyectoFinal2025.spring.DTO.response;

import ProyectoFinal2025.spring.DTO.request.LineaPedidoRequest;
import ProyectoFinal2025.spring.entity.LineaPedido;
import ProyectoFinal2025.spring.entity.Pedido;

import java.util.ArrayList;

public class PedidoResponse {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<LineaPedidoRequest> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaPedidoRequest> lineas) {
        this.lineas = lineas;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    private Long id;
    private ArrayList<LineaPedidoRequest> lineas;
    private double costoTotal;

    public PedidoResponse(Pedido pedido)
    {
        id = pedido.getIdPedido();
        lineas = new ArrayList<>();

        for (LineaPedido l : pedido.getLineas()) {
            lineas.add(new LineaPedidoRequest(l));
        }
        costoTotal=pedido.getCostoTotal();
    }

}
