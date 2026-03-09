package com.brennodev.cadastro_usuarios_api.business;

import com.brennodev.cadastro_usuarios_api.infrastructure.entity.Usuario;
import com.brennodev.cadastro_usuarios_api.infrastructure.exceptions.ConflictException;
import com.brennodev.cadastro_usuarios_api.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario salvaUsuario(Usuario usuario){
        try{
            emailExiste(usuario.getEmail());
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
}
