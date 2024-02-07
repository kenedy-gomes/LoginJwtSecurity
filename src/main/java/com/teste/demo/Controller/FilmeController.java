package com.teste.demo.Controller;


import com.teste.demo.Repositories.FilmeRepository;
import com.teste.demo.Services.FilmeService;
import com.teste.demo.model.Filme;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
    public Optional<Filme> getFilmesId(@PathVariable String id) {
        return filmeService.getFilmeById(id);
    }

    @GetMapping("/tipo/{tipo}")
    @PreAuthorize("permitAll()")
    public List<Filme> buscarPorTipo(@PathVariable(required = false) String tipo) {
        if (tipo == null) {
            return filmeService.getAllfilme();
        } else {
            return filmeService.buscarPorTipo(tipo);
        }
    }

    @PostMapping()
    public ResponseEntity saveFilme(@RequestBody Filme filme) {
        if (filmeService.existsByTitulo(filme.getName())) {
            return ResponseEntity.badRequest().body("Filme with this title already exists");
        }
        Filme savedFilme = filmeService.saveFilme(filme);
        return ResponseEntity.ok().body(savedFilme);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilme(@PathVariable String id) {
        filmeService.deleteFilme(id);
    }
}
