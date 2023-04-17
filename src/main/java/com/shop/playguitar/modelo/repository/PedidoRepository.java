package com.shop.playguitar.modelo.repository;

import java.util.Date;

import java.util.List;

import com.shop.playguitar.modelo.bean.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shop.playguitar.modelo.bean.PedidosProductos;
import com.shop.playguitar.modelo.bean.Producto;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	/*
	List<Pedido> findAllByFecha(Date date);
	
	List<Pedido> findAllByIdDireccione(int id);
	*/
	//Si esta query da problemas, probar con la de abajo por el tipo de fecha
	@Query("SELECT p FROM Pedido p WHERE p.fecha >= ?1")
	public List<Pedido> mostrarPedidosPorFecha(Date fecha);
	
	/*
	  @Query("SELECT p FROM Pedido p WHERE p.fecha >= STR_TO_DATE(?1, '%Y-%m-%d %H:%i:%s')")
		public List<Pedido> mostrarPedidosPorFecha(String fecha);

	 */
	
	@Query("SELECT p FROM Pedido p WHERE p.usuario.idUsuario = ?1")
	public List<Pedido> mostrarPedidosPorCliente(int idUsuario);
	
	@Query("Select p FROM Pedido p where p.usuario.idUsuario =?1 and  p.estado = 'CARRITO'")
	 Pedido mostrarPedidoCarritoPorCliente(int idUsuario);

	public void save(PedidosProductos productosPedido);

	@Query(value = "SELECT * FROM proyecto_servidor.productos_en_pedidos WHERE ID_PEDIDO = ?1", nativeQuery = true)
	List<PedidosProductos> buscarTodosPorIdPedido(int idPedido);

	public void save(Producto producto);
	
}
