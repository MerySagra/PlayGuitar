package com.shop.playguitar.modelo.service;

import java.util.Date;
import java.util.List;

import com.shop.playguitar.modelo.bean.Pedido;

public interface PedidoService {
	
	//public List<Pedido> findAllByFecha(Date fecha);
	//public List<Pedido> findAllByIdDireccione(int id);
	
	int nuevoPedido(Pedido pedido);
	List<Pedido> mostrarPedidoFecha(Date fecha);
	List<Pedido> mostrarPedidoCliente(int idUsuario);
	Pedido mostrarPedido(int idPedido);
	
	boolean byeStock(Pedido pedido);


}
