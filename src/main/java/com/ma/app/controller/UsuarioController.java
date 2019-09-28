package com.ma.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    private BCryptPasswordEncoder encoder;

    public UsuarioController(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping("/demo")
    public String pruebaBcrypt() {
        String clave = "mari123";
        String encriptado = encoder.encode(clave);
        logger.log(Level.INFO, "Clave encriptada {0}", encriptado);
        return "usuarios/demo";
    }

}
