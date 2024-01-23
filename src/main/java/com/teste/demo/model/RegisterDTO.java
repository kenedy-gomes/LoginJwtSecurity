package com.teste.demo.model;

import com.teste.demo.model.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
