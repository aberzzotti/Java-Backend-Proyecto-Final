package ProyectoFinal2025.spring.Controller;


import ProyectoFinal2025.spring.DTO.request.ProductRequest;
import ProyectoFinal2025.spring.DTO.response.ProductResponse;
import ProyectoFinal2025.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {
    private ProductService productService;


    @Autowired
    public ProductController(ProductService service) {
        this.productService = service;
    }

    // Listar todos los productos disponibles
    @GetMapping(("/listar"))
    public ResponseEntity<List<ProductResponse>> listarTodos() {
        List<ProductResponse> productos = productService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    //Obtener detalles individuales de un producto
    @GetMapping("/obtener/{id}")
    public ResponseEntity<ProductResponse> obtenerPorId(@PathVariable Long id) {
        ProductResponse producto = productService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    // Agregar nuevo producto
    @PostMapping(("/agregar"))
    public ResponseEntity<ProductResponse> crearProducto(@RequestBody ProductRequest nuevoProducto) {
        ProductResponse creado = productService.crearProducto(nuevoProducto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }


    // 🗑Eliminar producto por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }




}

