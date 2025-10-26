package com.carritocompra.proyectorudy1.repository;

import com.carritocompra.proyectorudy1.entity.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {

}
