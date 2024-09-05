package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Empleado;
import com.example.demo.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empleados")

public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empledoService;
	
	@GetMapping
	public ResponseEntity<List<Empleado>> readAll(){
		try {
			List<Empleado> empleados= empledoService.readAll(); 
		    if (empleados.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			}
		    return new ResponseEntity<>(empleados, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado cat){
		try {
			Empleado c= empledoService.create(cat); 
			return new ResponseEntity<>(c, HttpStatus.OK); 
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") Long id){
		
		try {
			Empleado c= empledoService.read(id).get(); 
			
			return new ResponseEntity<>(c, HttpStatus.CREATED); 
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Empleado> delEmpleadp(@PathVariable("id") long id){
		try {
			empledoService.delete(id); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> upadateAcceso(@PathVariable("id") Long id, @Valid @RequestBody Empleado cat){
		Optional<Empleado> c = empledoService.read(id); 
		if (!c.isEmpty()) {
			return new ResponseEntity<>(empledoService.update(cat), HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	

}
