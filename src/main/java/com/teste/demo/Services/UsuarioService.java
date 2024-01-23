package com.teste.demo.Services;

import com.teste.demo.Repositories.UserRepository;
import com.teste.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UserRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
