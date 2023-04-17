package com.shop.playguitar.modelo.service.Impl;

import java.util.Date;

import java.util.List;

import com.shop.playguitar.modelo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Pedido;
import com.shop.playguitar.modelo.bean.PedidosProductos;
import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.repository.PedidoRepository;
import com.shop.playguitar.modelo.repository.ProductoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepository prepo;
	@Autowired
	ProductoRepository perepo;
	

	@Override
	public int nuevoPedido(Pedido pedido) {
		int filas=0;
		try {
			prepo.save(pedido);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Pedido> mostrarPedidoFecha(Date fecha) {
		
		return prepo.mostrarPedidosPorFecha(fecha);
	}

	@Override
	public List<Pedido> mostrarPedidoCliente(int idUsuario) {
	
		return prepo.mostrarPedidosPorCliente(idUsuario);
	}

	@Override
	public Pedido mostrarPedido(int idPedido) {
		
		return prepo.findById(idPedido).orElse(null);
	}
	
	/*
	@Override
	public List<Pedido> findAllByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return prepo.findAllByFecha(fecha);
	}
	
	public List<Pedido> findAllByIdDireccione(int id){
		return prepo.findAllByIdDireccione(id);
		
	}
	*/
	
	@Override
	public boolean byeStock(Pedido pedido) {
		List<PedidosProductos> listaPep = prepo.buscarTodosPorIdPedido(pedido.getIdPedido());
		
		for (PedidosProductos pep : listaPep) {
			Producto producto = pep.getProducto();
			int cantidad = pep.getUnidades();
			
			int stock = perepo.verStock(pep.getProducto().getIdProducto());
			if (stock > 0) { 
				producto.setStock(stock - cantidad);
				prepo.save(producto);
			}else
				return false;
		}
		
		return true;
		
	}

}
