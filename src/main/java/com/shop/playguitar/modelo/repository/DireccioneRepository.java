package com.shop.playguitar.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.playguitar.modelo.bean.Direcciones;
import com.shop.playguitar.modelo.bean.Tarjeta;
import com.shop.playguitar.modelo.bean.UsuarioDirecciones;

public interface DireccioneRepository extends JpaRepository<Direcciones, Integer>{
	
	//Direccione findByDireccion(String direccion);


}
