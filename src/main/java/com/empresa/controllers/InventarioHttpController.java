package com.empresa.controllers;

import com.empresa.models.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InventarioHttpController {
    private final InventarioController inventarioController = new InventarioController();

    @GetMapping("/inventario")
    public ModelAndView inventarioPage() {
        ModelAndView mav = new ModelAndView("inventario");
        try {
            List<Producto> productos = inventarioController.listarProductos(true);
            mav.addObject("productos", productos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
}
