package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Direcciones;

public interface DireccioneService {

	//Método que devuelve todas la direcciones
	List<Direcciones> verTodas();

	//Método que devuelve una dirección por su id
	Direcciones verDireccione(int idDireccion);

}
