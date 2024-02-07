package com.teste.demo.Services;

import com.teste.demo.Repositories.UserRepository;
import com.teste.demo.model.ProfileDTO;
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

    public Optional<ProfileDTO> getUsuarioByEmail(String email) {
        return usuarioRepository.getUsuarioByEmail(email);
    }

    public Optional<Usuario> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

}
