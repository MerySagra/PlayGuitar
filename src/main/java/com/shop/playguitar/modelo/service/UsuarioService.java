package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.bean.Usuario;

public interface UsuarioService {
	
	//boolean registro(Usuario usuario);
	//Usuario findById(String username);
	//Usuario mostrarUsuario(String username);
	
	
	
	int modificarRol(Usuario usuario);
	
	
	List<Usuario> verTodos();
	
	Usuario verUsuario(int idUsuario);
	
	int altaUsuario(Usuario usuario);
	int eliminarUsuario(int idUsuario);
	int modificarUsuario(Usuario usuario);
	
	List<Tarjeta> addTarjetaUsuario(Usuario usuario, Tarjeta tarjeta);
	List<Tarjeta> removeTarjetaUsuario(Usuario usuario, Tarjeta tarjeta);
	
	List<Direcciones> addDireccioneUsuario(Usuario usuario, Direcciones direccione);
	List<Direcciones> removeDireccioneUsuario(Usuario usuario, Direcciones direccione);
	
	
	
	
	
	

}
