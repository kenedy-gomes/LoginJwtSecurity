package com.teste.demo.Repositories;


import com.teste.demo.model.ProfileDTO;
import com.teste.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Usuario, String> {
    UserDetails findByEmail(String login);
    Optional<ProfileDTO> getUsuarioByEmail(String email);

}
