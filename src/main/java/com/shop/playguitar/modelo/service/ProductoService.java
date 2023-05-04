package com.shop.playguitar.modelo.service;

import java.util.List;

import com.shop.playguitar.modelo.bean.Producto;


public interface ProductoService {

	List<Producto> findAll();
	List<Producto> findByName(String nombre);
	Producto findById(int idProducto);
	
	int altaProducto(Producto producto);
	int eliminarProducto(int idProducto);
	int modificarProducto(Producto producto);
	

	

	

}
