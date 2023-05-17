package com.shop.playguitar.modelo.service.Impl;

import java.util.List;

import com.shop.playguitar.modelo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository prepo;

	//Método que devuelve todos los productos
	@Override
	public List<Producto> findAll() {
		
		return prepo.findAll();
	}

	//Método que devuelve todos los productos por nombre
	@Override
	public List<Producto> findByName(String nombre) {
		
		return prepo.buscarPorNombre(nombre);
	}

	//Método que devuelve un producto por su id
	@Override
	public Producto findById(int idProducto) {
		
		return prepo.findById(idProducto).orElse(null);
	}

}
