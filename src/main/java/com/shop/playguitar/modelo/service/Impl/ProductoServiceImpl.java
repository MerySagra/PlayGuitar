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

	@Override
	public List<Producto> findAll() {
		
		return prepo.findAll();
	}


	@Override
	public List<Producto> findByName(String nombre) {
		
		return prepo.buscarPorNombre(nombre);
	}

	//Este es para ver el detalle del producto
	@Override
	public Producto findById(int idProducto) {
		
		return prepo.findById(idProducto).orElse(null);
	}
	

	@Override
	public int altaProducto(Producto producto) {
		int filas = 0;
		try {
			prepo.save(producto);
			filas = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public int eliminarProducto(int idProducto) {
		int filas = 0;
		try {
			prepo.deleteById(idProducto);
			filas=1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return filas;
	}


	@Override
	public int modificarProducto(Producto producto) {
		int filas=0;
		
			prepo.save(producto);
		return filas;
	}
	/*
	@Override
	public int cambiaProducto(Producto producto) {
		int cambia = 0;
		if(findByIdReal(producto.getIdProducto()) != null) {
			prepo.save(producto);
			cambia = 1;
		}
		return cambia;
	}
	*/
	



}
