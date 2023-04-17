package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Tarjeta;

public interface TarjetaService {
	/*
	boolean registro(Tarjeta tarjeta);
	public Tarjeta findById(String numTarjeta);
	*/
	
	List<Tarjeta> verTodas();
	
	Tarjeta verTarjeta(int idTarjeta);
	
	int altaTarjeta(Tarjeta tarjeta);
	int eliminarTarjeta(int idTarjeta);
	int modificarTarjeta(Tarjeta tarjeta);
}
