package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Role;
import com.shop.playguitar.modelo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository rrepo;
	/*
	@Override
	public Role findById(int id) {
		return rrepo.findById(id);
	}
	*/
	/*
	public Role editarRole(RoleUsuario role) {
		
		int cambia = 0;
		if(findByIdReal(producto.getIdProducto()) != null) {
			prepo.save(producto);
			cambia = 1;
		}
		return cambia;
		
	}
	*/

	@Override
	public List<Role> verRoles() {
		
		return rrepo.findAll();
	}

	@Override
	public Role verRole(int idRol) {
		
		return rrepo.findById(idRol).orElse(null);
	}

	@Override
	public int altaRol(Role role) {
		int filas = 0;
		try {
			rrepo.save(role);
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarRol(Role role) {
		int filas=0;
		if(verRole(role.getIdRol()) != null) {
			rrepo.save(role);
			filas=1;
		}
	return filas;
	}

	@Override
	public int eliminarRol(int idRol) {
		int filas = 0;
		try {
			rrepo.deleteById(idRol);
			filas=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}
	
	//TODO CREAR BEAN ROLE USUARIO PARA PODER EDITAR LA TABLA??
	
	

}
