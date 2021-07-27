package com.example.jpatest.controllers;
import java.util.ArrayList;
import java.util.List;

import com.example.jpatest.model.Categoria;
import com.example.jpatest.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Categoria> categorias = new ArrayList<Categoria>();

            categoriaRepository.findAll().forEach(categorias::add);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> createTutorial(@RequestBody Categoria categoria) {
        try {
            Categoria _categoria = categoriaRepository
                .save(categoria);
            return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
