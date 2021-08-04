package com.example.jpatest.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import com.example.jpatest.models.Categoria;
import com.example.jpatest.models.User;
import com.example.jpatest.projections.CategoriaCustom;
import com.example.jpatest.repository.CategoriaRepository;
import com.example.jpatest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Categoria> categorias = new ArrayList<Categoria>();
            
            // Get Current User 
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findOne(username);
            System.out.println(user.getId());

            categoriaRepository.findAll().forEach(categorias::add);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias2")
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        try {
            List<Categoria> categorias = new ArrayList<Categoria>();

            categoriaRepository.findCategorias().forEach(categorias::add);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias3")
    public ResponseEntity<List<CategoriaCustom>> getAllCategoriasQuery() {
        try {
            List<CategoriaCustom> categorias = new ArrayList<CategoriaCustom>();

            categoriaRepository.findCategoriasObject().forEach(categorias::add);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias4")
    public ResponseEntity<List<Map<String, Object>>> getAllCategoriasFunc() {
        try {
            List<Map<String, Object>> categorias = new ArrayList<Map<String, Object>>();

            categoriaRepository.findCategoriasFunc().forEach(categorias::add);
            if (categorias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> getTutorialById(@PathVariable("id") long id) {
        Optional<Categoria> data = categoriaRepository.findById(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categoria2/{id}")
    public ResponseEntity<CategoriaCustom> getCatById(@PathVariable("id") int id) {
        Optional<CategoriaCustom> data = categoriaRepository.findCategoriaById(id);
        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
