package com.brennodev.cadastro_usuarios_api.business;

import com.brennodev.cadastro_usuarios_api.infrastructure.entity.Usuario;
import com.brennodev.cadastro_usuarios_api.infrastructure.exceptions.ConflictException;
import com.brennodev.cadastro_usuarios_api.infrastructure.exceptions.ResourceNotFoundException;
import com.brennodev.cadastro_usuarios_api.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario){
        try{
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado", e.getCause());
        }

    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }


    public void emailExiste(String email){
        try {
           boolean existe =  verificaEmailExistente(email);
           if (existe){
               throw new ConflictException("Email já cadastrado" + email);
           }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }
    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" + email));
    }

    public void detelaUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
}
