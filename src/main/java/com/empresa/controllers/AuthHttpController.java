package com.empresa.controllers;

import com.empresa.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthHttpController {
    private final AuthController authController = new AuthController();

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/auth/login")
    public ModelAndView login(String correo, String contraseña) {
        ModelAndView mav = new ModelAndView();
        try {
            Usuario usuario = authController.login(correo, contraseña);
            if (usuario != null) {
                mav.setViewName("redirect:/inventario");
            } else {
                mav.setViewName("login");
                mav.addObject("error", "Credenciales incorrectas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
}
