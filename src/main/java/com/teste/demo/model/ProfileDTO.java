package com.teste.demo.model;

import com.teste.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;

public record ProfileDTO(String id, String name,  String email, String avatarImg, String role) {

    public static ProfileDTO fromUsuario(Usuario usuario){
        return new ProfileDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getUsername(),
                usuario.getAvatarImg(),
                usuario.getRole()
        );
    }

}
