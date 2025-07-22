package ProyectoFinal2025.spring.service;

import ProyectoFinal2025.spring.DTO.request.ProductRequest;
import ProyectoFinal2025.spring.DTO.response.ProductResponse;
import ProyectoFinal2025.spring.entity.Producto;
import ProyectoFinal2025.spring.repository.ProductRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository repositorio) {
        this.productRepository = repositorio;
    }


    public ProductResponse crearProducto(ProductRequest nuevoProducto) {
        Producto producto = new Producto();
        producto.setNombre(nuevoProducto.getNombre());
        producto.setPrecio(nuevoProducto.getPrecio());
        producto.setStock(nuevoProducto.getStock());
        ProductResponse productoFinal = new ProductResponse(productRepository.save(producto));
        return productoFinal;
    }


    public List<ProductResponse> listarProductos() {
        List<Producto> todos =   productRepository.findAll();
        List<ProductResponse> listaFinal = new ArrayList<>();
        for(Producto p: todos){
            ProductResponse nuevoP = new ProductResponse(p);
            listaFinal.add(nuevoP);
        }
        return listaFinal;

    }

    public ProductResponse obtenerProductoPorId(Long id) {

        Producto productoBuscado = productRepository.findById(id)
                .orElseThrow(() -> new ExpressionException("Producto no encontrado con ID: " + id));

        return new ProductResponse(productoBuscado);
    }
//throws ProductNotExistsException
    public void eliminarProducto(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ExpressionException("Producto no encontrado con ID: " + id);
        }
        this.productRepository.deleteById(id);

    }
    /*public List<ProductResponseDTO> filtrarPorPrecio(double precioMaximo){
        List<Product> listaDeProductos = productRepositoryJPA.findAll();
        List<ProductResponseDTO> productosFiltrados = new ArrayList<>();
        for(Product p: listaDeProductos){
            if(p.getPrice()<=precioMaximo) {
                ProductResponseDTO nuevoDTO = new ProductResponseDTO(p);
                productosFiltrados.add(nuevoDTO);
            }
        }
        return productosFiltrados;
    }
    public boolean hayStock(Long idProducto, int cantidad) throws ProductNotExistsException {
        Product productoBuscado = productRepositoryJPA.findById(idProducto)
                .orElseThrow(() -> new ProductNotExistsException("Producto no encontrado con ID: " + idProducto));
        return productoBuscado.getStock() >= cantidad;
    }

    public void descontarStock(long idProducto, int cantidad) throws ProductNotExistsException, NoStockException {
        Product productoADescontar = productRepositoryJPA.findById(idProducto)
                .orElseThrow(() -> new ProductNotExistsException("Producto no encontrado con ID: " + idProducto));
        if (productoADescontar.getStock() < cantidad) {
            throw new NoStockException("No hay suficiente stock para: " + productoADescontar.getTitle());
        }
        productoADescontar.setStock(productoADescontar.getStock() - cantidad);
        productRepositoryJPA.save(productoADescontar); // actualiza en la DB
    }

   public Product editarPrecio(Long id, Double nuevoPrecio) throws ProductNotExistsException {
        Product productoAACtualizar = productRepositoryJPA.findById(id)
                .orElseThrow(() -> new ProductNotExistsException("Producto no encontrado con ID: " + id));
        productoAACtualizar.setPrice(nuevoPrecio);

        this.productRepositoryJPA.save(productoAACtualizar);
        return productoAACtualizar;
    }
    */



}
