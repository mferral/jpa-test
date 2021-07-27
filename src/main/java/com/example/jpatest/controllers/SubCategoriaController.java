package com.example.jpatest.controllers; 
import java.util.ArrayList;
import java.util.List;

import com.example.jpatest.model.SubCategoria;
import com.example.jpatest.projections.SubCategoriaCustom;
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
import com.example.jpatest.projections.SubCategoriaClass;

@RestController
@RequestMapping("/api")
public class SubCategoriaController {
    @Autowired
    SubCategoriaRepository categoriaRepository;

    @GetMapping("/subcategorias")
    public ResponseEntity<List<SubCategoriaCustom>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            // List<SubCategoria> subcategorias = new ArrayList<SubCategoria>();
            List<SubCategoriaCustom> _subcategorias = new ArrayList<SubCategoriaCustom>();
            categoriaRepository.findAllProjectedBy().forEach(_subcategorias::add);
            // categoriaRepository.findAllProjectedBy().forEach(subcategorias::add);

            // Iterable<SubCategoriaCustom> all = categoriaRepository.findAllProjectedBy();
            // all.forEach(System.out::println);
            if (_subcategorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(_subcategorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/subcategorias2")
    public ResponseEntity<List<SubCategoriaClass>> getAllTutorials2() {
        try {
            
            List<SubCategoriaClass> _subcategorias = new ArrayList<SubCategoriaClass>();
            categoriaRepository.findAllBy().forEach(_subcategorias::add);            
            if (_subcategorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(_subcategorias, HttpStatus.OK);
        } catch (Exception e) {
            System.out.print(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/subcategoria")
    public ResponseEntity<SubCategoria> createTutorial(@RequestBody SubCategoria subcategoria) {
        try {
            SubCategoria _categoria = categoriaRepository.save(subcategoria);
            return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.print(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

