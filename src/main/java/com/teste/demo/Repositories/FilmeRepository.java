package com.teste.demo.Repositories;

import com.teste.demo.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, String> {
    List<Filme> findByTipo(String tipo);
    boolean existsByName(String name);
}
