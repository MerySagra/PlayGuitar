package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository urepo;

	//Método que devuelve una lista de todos los usuarios
	@Override
	public List<Usuario> findAll() {return urepo.findAll();}

	//Método que devuelve un usuario por su id
	@Override
	public Usuario findById(int idUsuario) {
		return urepo.findById(idUsuario).orElse(null);
	}

	//Método que devuelve un usuario por su email
	@Override
	public Usuario findByEmail(String email) {
			return urepo.findByEmail(email);
	}

	//Método que devuelve un usuario por su id con la dirección
	@Override
	public Usuario findByIdWithAddress(int idUsuario){
		return urepo.findByIdWithAddress(idUsuario);
	}

}
