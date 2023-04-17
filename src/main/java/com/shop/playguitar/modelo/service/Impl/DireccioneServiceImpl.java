package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.DireccioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.bean.UsuarioDirecciones;
import com.shop.playguitar.modelo.repository.DireccioneRepository;
import com.shop.playguitar.modelo.repository.TarjetaRepository;

@Service
public class DireccioneServiceImpl implements DireccioneService {
	
	
	@Autowired
	private DireccioneRepository drepo;

	@Override
	public List<Direcciones> verTodas() {
		
		return drepo.findAll();
	}

	@Override
	public Direcciones verDireccione(int idDireccion) {
		
		return drepo.findById(idDireccion).orElse(null);
	}

	@Override
	public int altaDireccion(Direcciones direccione) {
		int filas=0;
		try {
			drepo.save(direccione);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarDireccion(int idDireccion) {
		int filas=0;
		try {
			drepo.deleteById(idDireccion);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarDireccion(Direcciones direccione) {
		int filas=0;
		if(verDireccione(direccione.getIdDireccion()) != null) {
			drepo.save(direccione);
			filas=1;
		}
		return filas;
	}

	/*
	@Override
	public boolean registro(Direccione direccion) {
		if (findById(direccion.getCalle()) == null) {
				drepo.save(direccion);
				return true;
		}
		return false;
	}
	*/
	/*
	@Override
	public Direccione findById(String direccion) {
		return drepo.findByDireccion(direccion);
	}
	*/

}
