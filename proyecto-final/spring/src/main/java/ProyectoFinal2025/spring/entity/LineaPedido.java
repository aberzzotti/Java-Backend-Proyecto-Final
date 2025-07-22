package ProyectoFinal2025.spring.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class LineaPedido {

    Long idProducto;
    int cantidad;

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

    public LineaPedido() {}
}
