package com.example.biblioteca.controller;
import com.example.biblioteca.model.Genero;
import com.example.biblioteca.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // endereço do front
@RestController

@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepository;
    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }
    @PostMapping
    public Genero criarFabricante(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

}