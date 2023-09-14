package com.example.biblioteca.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Livro {
    @Id
    private String titulo;
    private int ano;
    private int paginas;


    @ManyToOne
    private Genero genero;


    @ManyToOne
    private Autor autor;
}