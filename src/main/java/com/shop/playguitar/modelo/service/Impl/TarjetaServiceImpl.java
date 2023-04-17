package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.repository.TarjetaRepository;

@Service
public class TarjetaServiceImpl implements TarjetaService {
	
	@Autowired
	private TarjetaRepository trepo;

	@Override
	public List<Tarjeta> verTodas() {
		
		return trepo.findAll();
	}

	@Override
	public Tarjeta verTarjeta(int idTarjeta) {
		
		return trepo.findById(idTarjeta).orElse(null);
	}

	@Override
	public int altaTarjeta(Tarjeta tarjeta) {
		int filas=0;
		try {
			trepo.save(tarjeta);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminarTarjeta(int idTarjeta) {
		int filas=0;
		try {
			trepo.deleteById(idTarjeta);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarTarjeta(Tarjeta tarjeta) {
		int filas=0;
		if(verTarjeta(tarjeta.getIdTarjeta()) != null) {
			trepo.save(tarjeta);
			filas=1;
		}
		
		return filas;
	}

	/*
	@Override
	public boolean registro(Tarjeta tarjeta) {
		if (findById(tarjeta.getNumTarjeta()) == null) {
				trepo.save(tarjeta);
				return true;
		}
		return false;
	}
	
	@Override
	public Tarjeta findById(String numTarjeta) {
		return trepo.findByNumTarjeta(numTarjeta);
	}
	*/
}
