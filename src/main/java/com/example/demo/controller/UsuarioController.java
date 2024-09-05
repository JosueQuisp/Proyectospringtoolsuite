package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Acceso;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@GetMapping
	public ResponseEntity<List<Usuario>> readAll(){
		try {
			
			List<Usuario> usuarios= usuarioService.readAll();
			
			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		     
		} catch (Exception e) {
              //TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping
	public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario cat){
		try {
			Usuario c = usuarioService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getusuario(@PathVariable("id") Long id){
		try {
			Usuario c= usuarioService.read(id).get(); 
			
			return new ResponseEntity<>(c, HttpStatus.CREATED); 
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delusuario(@PathVariable("id") long id){
		try {
			usuarioService.delte(id); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> upadateusuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario cat){
		Optional<Usuario> c = usuarioService.read(id); 
		if (!c.isEmpty()) {
			return new ResponseEntity<>(usuarioService.update(cat), HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	

}