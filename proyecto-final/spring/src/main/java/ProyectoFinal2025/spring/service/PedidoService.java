package ProyectoFinal2025.spring.service;

import ProyectoFinal2025.spring.DTO.request.LineaPedidoRequest;
import ProyectoFinal2025.spring.DTO.request.PedidoRequest;
import ProyectoFinal2025.spring.DTO.response.PedidoResponse;
import ProyectoFinal2025.spring.DTO.response.ProductResponse;
import ProyectoFinal2025.spring.entity.LineaPedido;
import ProyectoFinal2025.spring.entity.Pedido;
import ProyectoFinal2025.spring.entity.Producto;
import ProyectoFinal2025.spring.exceptions.NoStockException;
import ProyectoFinal2025.spring.exceptions.PedidoNoExisteException;
import ProyectoFinal2025.spring.exceptions.ProductoNoExisteException;
import ProyectoFinal2025.spring.repository.PedidoRepository;
import ProyectoFinal2025.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;
    private ProductRepository productRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ProductRepository productRepository)
    {
        this.productRepository = productRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResponse crearPedido(PedidoRequest request) throws ProductoNoExisteException, NoStockException {
        List<LineaPedido> lineas = new ArrayList<>();
        double costoTotal = 0;

        for (LineaPedidoRequest linea : request.getLineas()) {
            Producto p = productRepository.findById(linea.getIdProducto())
                    .orElseThrow(() -> new ProductoNoExisteException("No hay producto ID: " + linea.getIdProducto()));

            if (p.getStock() < linea.getCantidad()) {
                throw new NoStockException("No hay stock para el producto ID: " + linea.getIdProducto());
            }

            LineaPedido lineaPedido = new LineaPedido();
            lineaPedido.setIdProducto(p.getId());
            lineaPedido.setCantidad(linea.getCantidad());

            lineas.add(lineaPedido);
            costoTotal += linea.getCantidad() * p.getPrecio();
        }

        Pedido pedido = new Pedido();
        pedido.setLineas(lineas);
        pedido.setCostoTotal(costoTotal);
        Pedido nuevoPedido = this.pedidoRepository.save(pedido);

        PedidoResponse response = new PedidoResponse(nuevoPedido);

        return response;
    }

    public boolean confirmar(Long id) throws PedidoNoExisteException, NoStockException {
        Pedido pedido = this.pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNoExisteException("No existe el pedido: " + id));

        for (LineaPedido linea : pedido.getLineas()) {
            Producto p = productRepository.findById(linea.getIdProducto())
                    .orElseThrow(RuntimeException::new);

            if (p.getStock() < linea.getCantidad()) {
                throw new NoStockException("No hay stock para el producto ID: " + linea.getIdProducto());
            }

            p.setStock(p.getStock() -  linea.getCantidad());

            productRepository.save(p);
        }

        return true;
    }

    public List<PedidoResponse> listarPedidos() {
        List<Pedido> todos =  pedidoRepository.findAll();
        List<PedidoResponse> listaFinal = new ArrayList<>();
        for(Pedido p: todos){
            PedidoResponse nuevoP = new PedidoResponse(p);
            listaFinal.add(nuevoP);
        }
        return listaFinal;
    }
}
