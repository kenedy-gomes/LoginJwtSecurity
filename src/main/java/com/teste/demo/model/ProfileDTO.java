package com.teste.demo.model;

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
