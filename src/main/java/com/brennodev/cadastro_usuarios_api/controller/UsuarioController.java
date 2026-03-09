package com.brennodev.cadastro_usuarios_api.controller;

import com.brennodev.cadastro_usuarios_api.business.UsuarioService;
import com.brennodev.cadastro_usuarios_api.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private  final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario>  salvaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }
}
