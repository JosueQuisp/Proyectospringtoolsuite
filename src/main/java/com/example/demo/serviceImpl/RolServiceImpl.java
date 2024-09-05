package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RolDao;
import com.example.demo.entity.Rol;
import com.example.demo.service.RolService;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    private RolDao roldao; 
	@Override
	public Rol create(Rol c) {
		// TODO Auto-generated method stub
		return roldao.create(c);
	}

	@Override
	public Rol update(Rol c) {
		// TODO Auto-generated method stub
		return roldao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roldao.delete(id);
	}

	@Override
	public Optional<Rol> read(Long id) {
		// TODO Auto-generated method stub
		return roldao.read(id);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return roldao.readAll();
	}

}
