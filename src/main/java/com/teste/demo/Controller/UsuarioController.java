package com.teste.demo.Controller;


import com.auth0.jwt.JWT;
import com.teste.demo.Services.UsuarioService;
import com.teste.demo.model.ProfileDTO;
import com.teste.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    /*LISTAR TODOS*/
    @GetMapping
    public List<Usuario> getAllProdutos() {
        return usuarioService.getAllUsuarios();
    }

    /*LISTAR PERFIL*/
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String authorizationHeader){
        try {
            String email = JWT.decode(authorizationHeader.replace("Bearer ", "")).getSubject();
            Optional<ProfileDTO> usuarioOptional = usuarioService.getUsuarioByEmail(email);
            if(usuarioOptional.isPresent()) {
                ProfileDTO usuario = usuarioOptional.get();
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter perfil do usuário");
        }
    }

    /*LISTAR POR ID*/
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id);
    }

    /*CRIAÇÃO DE CONTA*/
    @PostMapping
    public ResponseEntity<Usuario> createAccount(@RequestBody Usuario usuario) {
        Usuario newAccount = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    /*EDITAR PERFIL*/
    @PutMapping("/edit/{id}")
    public ResponseEntity<ProfileDTO> updateUserProfile(@PathVariable String id, @RequestBody ProfileDTO profileDTO) {
        Optional<Usuario> usuarioOptional = usuarioService.getUsuarioById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setName(profileDTO.name());
            usuario.setEmail(profileDTO.email());
            usuario.setRole(profileDTO.role());
            Usuario updatedUser = usuarioService.updateProfile(usuario);
            ProfileDTO updatedProfileDTO = ProfileDTO.fromUsuario(updatedUser);
            return new ResponseEntity<>(updatedProfileDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*DELETAR USUARIO POR ID*/
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioService.deleteUsuario(id);
    }

    /*UPLOAD DA FOTO DE PERFIL*/
    @PostMapping("/upload-avatar")
    public ResponseEntity<String> uploadAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is empty");
        }
        try {
            usuarioService.uploadAvatar(id, file);
            return ResponseEntity.ok("Avatar uploaded successfully!");
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload avatar", e);
        }
    }
}
