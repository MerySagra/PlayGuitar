package com.shop.playguitar.modelo.service;

import java.math.BigDecimal;
import java.util.List;

import com.shop.playguitar.modelo.bean.PedidosProductos;

public interface PedidosProductosService {
	
	BigDecimal totalVenta(int idPedido);
	List<PedidosProductos> pedidosProductosCliente(int idUsuario);

}
