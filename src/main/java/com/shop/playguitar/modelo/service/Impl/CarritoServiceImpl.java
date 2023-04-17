package com.shop.playguitar.modelo.service.Impl;

import java.math.BigDecimal;
import java.util.*;

import com.shop.playguitar.modelo.service.CarritoService;
import com.shop.playguitar.modelo.service.PedidoService;
import com.shop.playguitar.modelo.service.PedidosProductosService;
import com.shop.playguitar.modelo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.playguitar.modelo.bean.Pedido;
import com.shop.playguitar.modelo.bean.PedidosProductos;
import com.shop.playguitar.modelo.bean.Producto;
import com.shop.playguitar.modelo.bean.Usuario;
import com.shop.playguitar.modelo.repository.PedidoRepository;
import com.shop.playguitar.modelo.repository.PedidosProductosRepository;

@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired ProductoService productoService;
	@Autowired PedidoService pedidoService;
	@Autowired PedidosProductosService pedidosProductosService;
	@Autowired PedidoRepository prepo;
	@Autowired PedidosProductosRepository pprepo;


	//Añade el producto siempre que haya menos de 10 unidades de él
	@Override
	public void addProductoCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = productoService.verProducto(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			int cantAumentada = ++cantActual;
			if (cantAumentada <= 10) {
				carrito.put(producto, cantAumentada);
			}

		} else {
			carrito.put(producto, 1);
		}

	}
	
	
	//Resta el producto, a través de su id, que elimines de la cesta
	@Override
	public void eliminateProductoCarrito(Map<Producto, Integer> carrito, Integer idProducto) {
		Producto producto = productoService.verProducto(idProducto);

		if (carrito.containsKey(producto)) {
			int cantActual = carrito.get(producto);
			cantActual--;
			if (cantActual == 0) {
				carrito.remove(producto);
			} else {
				carrito.put(producto, cantActual);
			}
		}
	}


	//Guarda el carrito cuando sales. Si está vacio crea un pedido nuevo.
	@Override
	public void saveCarrito(Map<Producto, Integer> carrito, Usuario usuario) {
		if (carrito != null) {
			Pedido pedido = prepo.mostrarPedidoCarritoPorCliente(usuario.getIdUsuario());


			if (pedido == null) pedido = new Pedido();

			Date fechaActual = new Date();
			String estadoCarrito = "CARRITO";

			pedido.setFecha(fechaActual);
			pedido.setUsuario(usuario);
			pedido.setEstado(estadoCarrito);
			
			//TODO añadir columna estado a la bbdd

			List<PedidosProductos> productos = pedido.getPedidosproductos();

			//if (productos != null && !productos.isEmpty())
			//	prepo.deleteAllInBatch(productos);

			
			Pedido pedidoGuardado = prepo.save(pedido);

			for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {

				PedidosProductos productosPedido = new PedidosProductos();
				BigDecimal cantidad = new BigDecimal(entry.getValue());
				BigDecimal precio = entry.getKey().getPrecio();
				BigDecimal precioTotal = cantidad.multiply(precio);

				productosPedido.setPedido(pedidoGuardado);
				productosPedido.setProducto(entry.getKey());
				productosPedido.setUnidades((int) entry.getValue());
				productosPedido.setPrecio_venta(precioTotal);

				prepo.save(productosPedido);
			}

		}
	}

	//Recupera el carrito de BBDD
	@Override
	public Map<Producto, Integer> recuperarCarrito(Integer idUsuario) {
		Map<Producto, Integer> carrito = new HashMap<>();
		List<PedidosProductos> productosEnPedidoLista = pprepo.ProductosEnPedidoPorUsuario(idUsuario);

		for (PedidosProductos pep : productosEnPedidoLista) {
			Producto producto = pep.getProducto();
			Integer cantidad = pep.getUnidades();

			carrito.put(producto, cantidad);
		}

		return carrito;

	}
}



