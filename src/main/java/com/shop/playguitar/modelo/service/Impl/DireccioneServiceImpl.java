package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.DireccioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.repository.DireccioneRepository;


@Service
public class DireccioneServiceImpl implements DireccioneService {
	
	
	@Autowired
	private DireccioneRepository drepo;

	//Método que devuelve todas la direcciones
	@Override
	public List<Direcciones> verTodas() {
		
		return drepo.findAll();
	}

	//Método que devuelve una dirección por su id
	@Override
	public Direcciones verDireccione(int idDireccion) {
		
		return drepo.findById(idDireccion).orElse(null);
	}

}
