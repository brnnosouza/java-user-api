package com.brennodev.cadastro_usuarios_api.controller;

import com.brennodev.cadastro_usuarios_api.business.UsuarioService;
import com.brennodev.cadastro_usuarios_api.controller.dtos.UsuarioDTO;
import com.brennodev.cadastro_usuarios_api.infrastructure.entity.Usuario;
import com.brennodev.cadastro_usuarios_api.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }

    @PostMapping("/login")
    public String longin(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha()));
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<Usuario> buscaUsuarioPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> detelaUsuarioPorEmail(@PathVariable String email) {
        usuarioService.detelaUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

}
