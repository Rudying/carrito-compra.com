package com.carritocompra.proyectorudy1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="producto")
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    @Getter @Setter
    private Long idProducto;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "codigo")
    @Getter @Setter
    private String codigo;

    @Column(name = "precio")
    @Getter @Setter
    private double precio;

    @Column(name = "imagen")
    @Getter @Setter
    private String imagen;

    public Producto(Long idProducto, String nombre, String codigo, double precio, String imagen) {

        setIdProducto(idProducto);
        setNombre(nombre);
        setCodigo(codigo);
        setPrecio(precio);
        setImagen(imagen);

    }

    public Producto() {
    }

}
