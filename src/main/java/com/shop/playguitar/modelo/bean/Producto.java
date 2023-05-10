package com.shop.playguitar.modelo.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	@Lob
	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	private int stock;

	private String url;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"idProducto=" + idProducto +
				", descripcion='" + descripcion + '\'' +
				", nombre='" + nombre + '\'' +
				", precio=" + precio +
				", stock=" + stock +
				", url='" + url + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Producto)) return false;
		Producto producto = (Producto) o;
		return getIdProducto() == producto.getIdProducto() && getStock() == producto.getStock() && Objects.equals(getDescripcion(), producto.getDescripcion()) && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getPrecio(), producto.getPrecio()) && Objects.equals(getUrl(), producto.getUrl());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdProducto(), getDescripcion(), getNombre(), getPrecio(), getStock(), getUrl());
	}
}