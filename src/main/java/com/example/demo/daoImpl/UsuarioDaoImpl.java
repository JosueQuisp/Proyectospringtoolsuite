package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Component
public class UsuarioDaoImpl  implements UsuarioDao{
	
	@Autowired
	private UsuarioRepository usuariorepository; 

	@Override
	public Usuario create(Usuario c) {
		// TODO Auto-generated method stub
		return usuariorepository.save(c);
	}

	@Override
	public Usuario update(Usuario c) {
		// TODO Auto-generated method stub
		return usuariorepository.save(c);
	}

	@Override
	public void delte(Long id) {
		// TODO Auto-generated method stub
		usuariorepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> read(Long id) {
		// TODO Auto-generated method stub
		return usuariorepository.findById(id);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuariorepository.findAll();
	}

}
