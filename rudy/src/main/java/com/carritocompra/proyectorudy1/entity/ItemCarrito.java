package com.carritocompra.proyectorudy1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shopping_cart")
@ToString
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShoppingCart")
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @Getter
    @Setter
    private Producto producto;

    @Column(name = "cantidad")
    @Getter
    @Setter
    private int cantidad;

    public ItemCarrito(Long id, Producto producto, int cantidad) {
        setId(id);
        setProducto(producto);
        setCantidad(cantidad);

    }

    public ItemCarrito() {
    }
}
