package com.example.biblioteca.controller;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
// @CrossOrigin(origins = "http://localhost:5173") // endereço do front
@RestController

@RequestMapping("/veiculos")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarLivro (@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @DeleteMapping("/{titulo}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable String titulo) {
        try {
            livroRepository.deleteById(titulo);
            return ResponseEntity.ok("Livro deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{placa}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String titulo, @RequestBody Livro livroAtualizado) {
        if (livroRepository.existsById(titulo)) {
            Livro livro = livroRepository.findById(titulo).get();
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setGenero(livroAtualizado.getGenero());
            livro.setPaginas(livroAtualizado.getPaginas());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAno(livroAtualizado.getAno());
            Livro livroAtualizadoBD = livroRepository.save(livro);
            return ResponseEntity.ok(livroAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
