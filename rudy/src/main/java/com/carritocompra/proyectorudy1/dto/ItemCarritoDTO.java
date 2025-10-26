package com.carritocompra.proyectorudy1.dto;

import com.carritocompra.proyectorudy1.entity.Producto;
import lombok.Getter;
import lombok.Setter;

public class ItemCarritoDTO {
    @Getter @Setter
    private String nombreProducto;
    @Getter @Setter
    private int cantidad;
    @Getter @Setter
    private double precioUnitario;
    @Getter @Setter
    private double subtotal;

    public ItemCarritoDTO(Producto producto, int cantidad) {
        setNombreProducto(producto.getNombre());
        setPrecioUnitario(producto.getPrecio());
        setCantidad(cantidad);
        setSubtotal(cantidad * producto.getPrecio());
    }
}
