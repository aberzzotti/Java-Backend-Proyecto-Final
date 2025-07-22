package ProyectoFinal2025.spring.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPedido;

    @ElementCollection
    @CollectionTable(name = "lineas_pedido", joinColumns = @JoinColumn(name = "pedido_id"))
    public List<LineaPedido> lineas = new ArrayList<>();
    private double costoTotal;



    public Pedido() {}

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedido> lineas) {
        this.lineas = lineas;
    }

    public void agregarLinea(LineaPedido linea) {lineas.add(linea);}

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
