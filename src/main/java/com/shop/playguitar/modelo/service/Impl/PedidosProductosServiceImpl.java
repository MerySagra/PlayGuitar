package com.shop.playguitar.modelo.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.shop.playguitar.modelo.service.PedidosProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Pedido;
import com.shop.playguitar.modelo.bean.PedidosProductos;
import com.shop.playguitar.modelo.repository.PedidosProductosRepository;

@Service
public class PedidosProductosServiceImpl implements PedidosProductosService {
	
	@Autowired
	private PedidosProductosRepository pprepo;
	
	@Override
	public BigDecimal totalVenta(int idPedido) {
	
		return pprepo.sumaTotal(idPedido);
	}

	@Override
	public List<PedidosProductos> pedidosProductosCliente(int idUsuario) {
		
		return pprepo.pedidosProductosCliente(idUsuario);
	}

	
	
}
