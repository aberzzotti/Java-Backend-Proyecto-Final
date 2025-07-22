package ProyectoFinal2025.spring.repository;

import ProyectoFinal2025.spring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long>{
  //boolean existsByTitleIgnoreCase(String title);
}