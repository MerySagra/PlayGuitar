package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Role;

public interface RoleService {

	//public Role findById(int id);
	//public Role editarRole(RoleUsuario role);
	
	
	//Parte hecha por Javier
	
	List<Role> verRoles();
	Role verRole(int idRol);
	
	int altaRol(Role role);
	int modificarRol(Role role);
	int eliminarRol(int idRol);
}
