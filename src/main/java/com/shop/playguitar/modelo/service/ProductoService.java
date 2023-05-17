package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Producto;


public interface ProductoService {

	//Método que devuelve todos los productos
	List<Producto> findAll();
	//Método que devuelve todos los productos por nombre
	List<Producto> findByName(String nombre);
	//Método que devuelve un producto por su id
	Producto findById(int idProducto);

}
