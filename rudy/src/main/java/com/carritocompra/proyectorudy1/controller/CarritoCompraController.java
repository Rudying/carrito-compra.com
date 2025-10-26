package com.carritocompra.proyectorudy1.controller;

import com.carritocompra.proyectorudy1.dto.ItemCarritoDTO;
import com.carritocompra.proyectorudy1.entity.ItemCarrito;
import com.carritocompra.proyectorudy1.service.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoCompraController {

    @Autowired
    private CarritoCompraService carritoCompraService;


    @GetMapping
    public List<ItemCarrito> verCarrito(){
        return carritoCompraService.getAll();
    }

    @PostMapping
    public void agregarProducto(@RequestParam String codigo, @RequestParam int cantidad){
        carritoCompraService.agregar(codigo, cantidad);
    }

    @DeleteMapping("/{id}")
    public void eleminarProducto(@PathVariable Long id) {
        carritoCompraService.eliminar(id);
    }


    @DeleteMapping("/vaciar")
    public void vaciarCarrito(){
        carritoCompraService.vaciar();
    }

    @GetMapping("/resumen")
    public List<ItemCarritoDTO> obtenerResumen() {
        return carritoCompraService.getResumenCarrito();
    }

}
