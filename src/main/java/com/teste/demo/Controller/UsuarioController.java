package com.teste.demo.Controller;


import com.auth0.jwt.JWT;
import com.teste.demo.Services.UsuarioService;
import com.teste.demo.model.ProfileDTO;
import com.teste.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllProdutos() {
        return usuarioService.getAllUsuarios();
    }

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


    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> createAccount(@RequestBody Usuario usuario) {
        Usuario newAccount = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioService.deleteUsuario(id);
    }
}
