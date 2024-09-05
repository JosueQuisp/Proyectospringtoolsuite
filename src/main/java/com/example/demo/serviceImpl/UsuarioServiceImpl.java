package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioDao usuariodao; 
	@Override
	public Usuario create(Usuario c) {
		// TODO Auto-generated method stub
		return usuariodao.create(c);
	}

	@Override
	public Usuario update(Usuario c) {
		// TODO Auto-generated method stub
		return usuariodao.update(c);
	}

	@Override
	public void delte(Long id) {
		// TODO Auto-generated method stub
		usuariodao.delte(id);
	}

	@Override
	public Optional<Usuario> read(Long id) {
		// TODO Auto-generated method stub
		return usuariodao.read(id);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuariodao.readAll();
	}

}
