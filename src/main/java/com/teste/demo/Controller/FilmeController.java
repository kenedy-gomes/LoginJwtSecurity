package com.teste.demo.Controller;


import com.teste.demo.Repositories.FilmeRepository;
import com.teste.demo.Services.FilmeService;
import com.teste.demo.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeService.getAllfilme();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmesId(@PathVariable Long id) {
        return filmeService.getFilmeById(id);
    }


    @PostMapping()
    public ResponseEntity saveFilme(@RequestBody Filme filme) {
        if (filmeService.existsByTitulo(filme.getName())) {
            return ResponseEntity.badRequest().body("Filme with this title already exists");
        }

        // Salvar o filme se o título ainda não estiver cadastrado
        Filme savedFilme = filmeService.saveFilme(filme);

        return ResponseEntity.ok().body(savedFilme);
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable Long id) {
        filmeService.deleteFilme(id);
    }
}
