package com.carritocompra.proyectorudy1.controller;

import com.carritocompra.proyectorudy1.dto.ItemCarritoDTO;
import com.carritocompra.proyectorudy1.service.CarritoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VistaCarritoCompra {

    @Autowired
    private CarritoCompraService carritoCompraService;

    @DeleteMapping("/vaciar")
    public void vaciarCarrito() {
        carritoCompraService.vaciar();
    }

    @PostMapping("/carrito/agregar")
    public ResponseEntity<Void> agregarDesdeVista(@RequestParam String codigo, @RequestParam int cantidad) {
        try {
            carritoCompraService.agregar(codigo, cantidad);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/carrito/vaciar")
    public String vaciarDesdeVista() {
        carritoCompraService.vaciar();
        return "redirect:/carrito/vista";
    }


    @GetMapping("/carrito/vista")
    public String mostrarCarrito(Model model) {
        List<ItemCarritoDTO> resumen = carritoCompraService.getResumenCarrito();

        // ✅ Calcular el total sumando los subtotales
        double total = resumen.stream()
                .mapToDouble(ItemCarritoDTO::getSubtotal)
                .sum();

        // ✅ Pasar los datos a la vista
        model.addAttribute("items", resumen);
        model.addAttribute("total", total);

        return "carrito"; // Thymeleaf
    }
}
