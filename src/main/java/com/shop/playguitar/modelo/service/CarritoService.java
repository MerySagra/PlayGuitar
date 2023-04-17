package com.shop.playguitar.modelo.service;

import java.util.Map;

import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.bean.Usuario;



public interface CarritoService {

	void addProductoCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void eliminateProductoCarrito(Map<Producto,Integer> carrito, Integer idProducto);
	void saveCarrito(Map<Producto,Integer> carrito, Usuario usuario);
	Map<Producto,Integer> recuperarCarrito(Integer idUsuario);
	/**
	 * Si el carrito ya contiene el producto y no supera las 10 uds,
	 * añade una unidad al producto con el Id pasado por parámetro
	 * Si el carrito no lo contiene, añade una unidad
	 */

}
