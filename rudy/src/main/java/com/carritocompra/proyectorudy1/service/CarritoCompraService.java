package com.carritocompra.proyectorudy1.service;

import com.carritocompra.proyectorudy1.dto.ItemCarritoDTO;
import com.carritocompra.proyectorudy1.entity.ItemCarrito;
import com.carritocompra.proyectorudy1.entity.Producto;
import com.carritocompra.proyectorudy1.repository.ItemCarritoRepository;
import com.carritocompra.proyectorudy1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;



@Service
public class CarritoCompraService {

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    //Devolverá los items del carrito como LinkedList
    public List<ItemCarrito> getAll() {
        LinkedList<ItemCarrito> carrito = new LinkedList<>(itemCarritoRepository.findAll());
        return carrito;
    }

    //agrega un producto al carrito usando su código
    public void agregar(String codigo, int cantidad){
        Producto producto = productoRepository.findByCodigo(codigo);

        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado con código: " + codigo);
        }

        double subtotal = producto.getPrecio() * cantidad;
        ItemCarrito item = new ItemCarrito(null, producto, cantidad);
        itemCarritoRepository.save(item);
    }

    //Elimina un item del carrito por ID
    public void eliminar (Long id) {
        itemCarritoRepository.deleteById(id);
    }

    public void vaciar() {
        itemCarritoRepository.deleteAll();
    }

    public List<ItemCarritoDTO> getResumenCarrito() {
        List<ItemCarrito> items = itemCarritoRepository.findAll();
        List<ItemCarritoDTO> resumen = new LinkedList<>();

        for (ItemCarrito item : items) {
            resumen.add(new ItemCarritoDTO(item.getProducto(), item.getCantidad()));
        }

        return resumen;
    }

}
