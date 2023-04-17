package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Direcciones;

public interface DireccioneService {
	
	//boolean registro(Direccione direccion);
	//public Direccione findById(String direccion);
	
	List<Direcciones> verTodas();
	
	Direcciones verDireccione(int idDireccion);
	
	int altaDireccion(Direcciones direccione);
	int eliminarDireccion(int idDireccion);
	int modificarDireccion(Direcciones direccione);


}
