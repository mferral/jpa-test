package com.example.jpatest.controllers;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")	
	public ResponseEntity<String> test(HttpServletRequest request) throws IOException {		
        return ResponseEntity.ok().body("Hola Mundo!");
	}  
}
