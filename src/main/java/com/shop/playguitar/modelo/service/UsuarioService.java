package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Usuario;

public interface UsuarioService {

	//Método que devuelve una lista de todos los usuarios
	List<Usuario> findAll();

	//Método que devuelve un usuario por su id
	Usuario findById(int idUsuario);

	//Método que devuelve un usuario por su email
	Usuario findByEmail(String email);

	//Método que devuelve un usuario por su id con la dirección
	Usuario findByIdWithAddress(int idUsuario);

}
