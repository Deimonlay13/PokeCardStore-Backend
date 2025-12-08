package com.gdl.pokecardstore.controller;

import com.gdl.pokecardstore.entity.UsuarioEntity;
import com.gdl.pokecardstore.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public UsuarioEntity getById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PutMapping("/{id}")
    public UsuarioEntity update(
            @PathVariable Long id,
            @RequestBody UsuarioEntity request) {
        return usuarioService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return "Usuario eliminado correctamente";
    }
}
