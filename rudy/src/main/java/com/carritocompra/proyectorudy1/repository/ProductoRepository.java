package com.carritocompra.proyectorudy1.repository;

import com.carritocompra.proyectorudy1.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByCodigo(String codigo);

}
