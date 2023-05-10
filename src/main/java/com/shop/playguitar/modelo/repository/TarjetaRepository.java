package com.shop.playguitar.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.bean.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
	
	//Tarjeta findByNumTarjeta(String numTarjeta);

}
