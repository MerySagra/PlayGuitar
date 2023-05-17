package com.shop.playguitar.modelo.bean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the pedidos database table.
 * 
 */

@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private String estado;

	//uni-directional many-to-one association to Direccione
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direcciones direcciones;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;
	
	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	//bi-directional many-to-one association to PedidosProductos
	@OneToMany(mappedBy="pedido", cascade= {CascadeType.PERSIST})
	private List<PedidosProductos> pedidosproductos;

	public Pedido() {
	}

	//Getters y Setters
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Direcciones getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(Direcciones direccione) {
		this.direcciones = direcciones;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<PedidosProductos> getPedidosproductos() {
		return pedidosproductos;
	}

	public void setPedidosproductos(List<PedidosProductos> pedidosproductos) {
		this.pedidosproductos = pedidosproductos;
	}

	public PedidosProductos addPedidosProductos(PedidosProductos pedidosproductos) {
		getPedidosproductos().add(pedidosproductos);
		pedidosproductos.setPedido(this);
		
		return pedidosproductos;
	}
	
	public PedidosProductos removePedidosProductos(PedidosProductos pedidosproductos) {
		getPedidosproductos().add(pedidosproductos);
		pedidosproductos.setPedido(this);
		
		return pedidosproductos;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + ", direccione=" + direcciones + ", tarjeta="
				+ tarjeta + ", usuario=" + usuario + ", pedidosproductos=" + pedidosproductos + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pedido pedido = (Pedido) o;
		return getIdPedido() == pedido.getIdPedido() && getFecha().equals(pedido.getFecha()) && getEstado().equals(pedido.getEstado()) && getDirecciones().equals(pedido.getDirecciones()) && getTarjeta().equals(pedido.getTarjeta()) && getUsuario().equals(pedido.getUsuario()) && getPedidosproductos().equals(pedido.getPedidosproductos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdPedido(), getFecha(), getEstado(), getDirecciones(), getTarjeta(), getUsuario(), getPedidosproductos());
	}
}