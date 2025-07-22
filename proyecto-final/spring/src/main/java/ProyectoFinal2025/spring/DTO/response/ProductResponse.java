package ProyectoFinal2025.spring.DTO.response;


import ProyectoFinal2025.spring.entity.Producto;

public class ProductResponse {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    public ProductResponse(Producto unProducto){
        this.id = unProducto.getId();
        this.nombre = unProducto.getNombre();
        this.precio = unProducto.getPrecio();
        this.stock = unProducto.getStock();
    }

    public Long getId() {return this.id;}
    public String getNombre() {return this.nombre;}
    public double getPrecio() {return this.precio;}

    public int getStock() {return stock;}
}