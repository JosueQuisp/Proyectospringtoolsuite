package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Acceso;
import com.example.demo.service.AccesosService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/accesos")

public class AccesoController {
	
	@Autowired
	private AccesosService accesoService; 
	
	@GetMapping
	public ResponseEntity<List<Acceso>> readAll(){
		try {
			
			List<Acceso> accesos= accesoService.readAll();
			
			if (accesos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(accesos, HttpStatus.OK);
		     
		} catch (Exception e) {
              //TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping
	public ResponseEntity<Acceso> crear(@Valid @RequestBody Acceso cat){
		try {
			Acceso c = accesoService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acceso> getAcceso(@PathVariable("id") Long id){
		try {
			Acceso c= accesoService.read(id).get(); 
			
			return new ResponseEntity<>(c, HttpStatus.CREATED); 
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Acceso> delAcceso(@PathVariable("id") long id){
		try {
			accesoService.delete(id); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> upadateAcceso(@PathVariable("id") Long id, @Valid @RequestBody Acceso cat){
		Optional<Acceso> c = accesoService.read(id); 
		if (!c.isEmpty()) {
			return new ResponseEntity<>(accesoService.update(cat), HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
		
}
