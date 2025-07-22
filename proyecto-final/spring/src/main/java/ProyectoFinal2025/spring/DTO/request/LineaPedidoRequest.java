package ProyectoFinal2025.spring.DTO.request;

import ProyectoFinal2025.spring.entity.LineaPedido;
import ProyectoFinal2025.spring.entity.Pedido;

import java.util.ArrayList;

public class LineaPedidoRequest {


    public LineaPedidoRequest(LineaPedido l) {
            this.idProducto = l.getIdProducto();
            this.cantidad=l.getCantidad();
    }
    public LineaPedidoRequest(){}
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    Long idProducto;
    int cantidad;
}
