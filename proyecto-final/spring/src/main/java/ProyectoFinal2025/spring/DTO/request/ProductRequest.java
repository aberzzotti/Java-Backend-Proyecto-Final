package ProyectoFinal2025.spring.DTO.request;

public class ProductRequest {
    private String nombre;
    private double precio;
    private int stock;

    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return stock;}

    public void setNombre(String unNombre) {this.nombre = unNombre;}
    public void setPrice(double unPrecio) {this.precio = unPrecio;}
    public void setStock(int unStock) {this.stock = unStock;}
}

