package com.teste.demo.Repositories;


import com.teste.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String login);
}
