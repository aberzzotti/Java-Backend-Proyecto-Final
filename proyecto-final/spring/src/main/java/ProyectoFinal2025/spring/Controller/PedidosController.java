package ProyectoFinal2025.spring.Controller;

import ProyectoFinal2025.spring.DTO.request.PedidoRequest;
import ProyectoFinal2025.spring.DTO.response.PedidoResponse;
import ProyectoFinal2025.spring.exceptions.NoStockException;
import ProyectoFinal2025.spring.exceptions.PedidoNoExisteException;
import ProyectoFinal2025.spring.service.PedidoService;
import ProyectoFinal2025.spring.exceptions.ProductoNoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "${frontend.url}")

public class PedidosController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidosController(PedidoService pedidoService) { this.pedidoService = pedidoService; }

    @PostMapping("/crearPedido")
    public ResponseEntity<?> crear(@RequestBody PedidoRequest request)  {
        try {
            PedidoResponse nuevoPedido = pedidoService.crearPedido(request);

            return ResponseEntity.ok(nuevoPedido);
        } catch (ProductoNoExisteException | NoStockException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
        }
    }

    @PostMapping("/confirmar/{id}")
    public ResponseEntity<?> confirmar(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(pedidoService.confirmar(id));
        } catch (PedidoNoExisteException | NoStockException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar()  {
        try {
            return ResponseEntity.ok(pedidoService.listarPedidos());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
        }
    }
}
