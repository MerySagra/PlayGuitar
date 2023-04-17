package com.shop.playguitar.modelo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.playguitar.modelo.bean.PedidosProductos;

public interface PedidosProductosRepository extends JpaRepository<PedidosProductos, Integer>{
	
	@Query("SELECT sum(pp.precio_venta) FROM PedidosProductos pp WHERE pp.pedido.idPedido = ?1")
	public BigDecimal sumaTotal(int idPedido);
	
	@Query("SELECT pp FROM PedidosProductos pp WHERE pp.pedido.usuario.idUsuario = ?1")
	public List<PedidosProductos> pedidosProductosCliente(int idUsuario);
	
	//TODO revisar
	@Query(value = "SELECT PEP.* FROM ecommerce.PEDIDOS PED JOIN proyecto_servidor.productos_en_pedidos PEP ON PED.ID_PEDIDO = PEP.ID_PEDIDO WHERE PED.ID_USUARIO = ?1 AND PED.ESTADO = 'CARRITO'", nativeQuery = true)
	List<PedidosProductos>	ProductosEnPedidoPorUsuario(Integer idUsuario);

}
