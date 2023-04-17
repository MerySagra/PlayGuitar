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
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	/*
	@Override
	public boolean registro(Producto producto) {
		if (findById(producto.getNombre()) == null) {
				prepo.save(producto);
				return true;
		}
		return false;
	}
	*/
	/*
	@Override
	public Producto findById(String nombre) {
		return prepo.findByNombre(nombre);
	}
	*/
	/*
	@Override
	public Producto findByIdReal(int id) {
		return prepo.findById(id);
	}
	*/
	/*
	@Override
	public int bajaProducto(int id) {
		int filas = 0;
		if(findByIdReal(id) != null) {
			try {
			prepo.deleteById(id);
			filas = 1;
			}catch(Exception e) {
				filas=0;
			}
		}
		return filas;
	}
	*/


	//Parte hecha por Javier

	@Override
	public List<Producto> verTodos() {
		
		return prepo.findAll();
	}


	@Override
	public List<Producto> verProductosPorNombre(String nombre) {
		
		return prepo.buscarPorNombre(nombre);
	}

	//Este es para ver el detalle del producto
	@Override
	public Producto verProducto(int idProducto) {
		
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
