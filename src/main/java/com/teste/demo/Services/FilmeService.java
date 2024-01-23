package com.teste.demo.Services;

import com.teste.demo.Repositories.FilmeRepository;
import com.teste.demo.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> getAllfilme() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> getFilmeById(Long id) {
        return filmeRepository.findById(id);
    }

    public boolean existsByTitulo(String name) {
        return filmeRepository.existsByName(name);
    }
    public Filme saveFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deleteFilme(Long id) {
        filmeRepository.deleteById(id);
    }

}
