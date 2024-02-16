package com.teste.demo.Services;

import com.teste.demo.Exception.UsuarioNaoEncontradoException;
import com.teste.demo.Repositories.UserRepository;
import com.teste.demo.model.ProfileDTO;
import com.teste.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UsuarioService {

    private final Path avatarUploadDir = Paths.get("avatars");

    @Autowired
    private UserRepository usuarioRepository;


    /*LISTAR TODOS*/
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    /*LISTAR POR EMAIL*/
    public Optional<ProfileDTO> getUsuarioByEmail(String email) {
        return usuarioRepository.getUsuarioByEmail(email);
    }

    /*LISTAR POR ID*/
    public Optional<Usuario> getUsuarioById(String id) {
        return usuarioRepository.findById(id);
    }

    /*CADASTRAR USUARIO*/
    public Usuario saveUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    /*EDIT PROFILE*/
    public Usuario updateProfile(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /*DELETE USUARIO*/
    public void deleteUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    /*UPLOAD IMAGEM DO AVATAR*/
    public void uploadAvatar(String id, MultipartFile file) throws IOException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        usuario.setAvatarImg(fileName);
        usuarioRepository.save(usuario);
    }

}
