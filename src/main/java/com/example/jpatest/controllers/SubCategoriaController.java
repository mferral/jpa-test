package com.example.jpatest.controllers; 
import java.util.ArrayList;
import java.util.List;

import com.example.jpatest.model.SubCategoria;
import com.example.jpatest.repository.SubCategoriaRepository;

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
public class SubCategoriaController {
    @Autowired
    SubCategoriaRepository categoriaRepository;

    @GetMapping("/subcategorias")
    public ResponseEntity<List<SubCategoria>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<SubCategoria> subcategorias = new ArrayList<SubCategoria>();

            categoriaRepository.findAll().forEach(subcategorias::add);
            if (subcategorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(subcategorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subcategoria")
    public ResponseEntity<SubCategoria> createTutorial(@RequestBody SubCategoria subcategoria) {
        try {
            SubCategoria _categoria = categoriaRepository
                .save(subcategoria);
            return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

