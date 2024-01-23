package com.teste.demo.Repositories;

import com.teste.demo.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    boolean existsByName(String name);
}
