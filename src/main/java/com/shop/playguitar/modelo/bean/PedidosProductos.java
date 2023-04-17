
package com.shop.playguitar.modelo.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="pedidos_productos")
@NamedQuery(name="PedidosProductos.findAll", query="SELECT p FROM PedidosProductos p")
public class PedidosProductos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_orden")
	private int numeroOrden;
	
	private int unidades;
	
	private BigDecimal precio_venta;
	
	//bi-directional many-to-one association to Pedido
		@ManyToOne
		@JoinColumn(name="id_pedido")
		private Pedido pedido;
		
	//uni-directional many-to-one association to Producto
		@ManyToOne
		@JoinColumn(name="id_producto")
		private Producto producto;

		public int getNumeroOrden() {
			return numeroOrden;
		}

		public void setNumeroOrden(int numeroOrden) {
			this.numeroOrden = numeroOrden;
		}

		public int getUnidades() {
			return unidades;
		}

		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}

		public BigDecimal getPrecio_venta() {
			return precio_venta;
		}

		public void setPrecio_venta(BigDecimal d) {
			this.precio_venta = d;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		@Override
		public String toString() {
			return "PedidosProductos [numeroOrden=" + numeroOrden + ", unidades=" + unidades + ", precio_venta="
					+ precio_venta + ", pedido=" + pedido + ", producto=" + producto + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + numeroOrden;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof PedidosProductos))
				return false;
			PedidosProductos other = (PedidosProductos) obj;
			if (numeroOrden != other.numeroOrden)
				return false;
			return true;
		}

		
	

}
