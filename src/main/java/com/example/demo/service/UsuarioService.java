package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Usuario;

public interface UsuarioService {
	
	Usuario create(Usuario c); 
	Usuario update(Usuario c); 
	void delte(Long id) ; 
	Optional<Usuario> read(Long id); 
	List<Usuario> readAll();

}