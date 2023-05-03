package com.shop.playguitar.modelo.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

/**
 * The persistent class for the direcciones database table.
 * 
 */

@Entity
@Table(name="direcciones")
@NamedQuery(name="Direcciones.findAll", query="SELECT d FROM Direcciones d")
public class Direcciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private int idDireccion;

	private String calle;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String letra;

	private String localidad;

	private int numero;

	private String piso;

	public Direcciones() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	@Override
	public String toString() {
		return "Direccione [idDireccion=" + idDireccion + ", calle=" + calle + ", codigoPostal=" + codigoPostal
				+ ", letra=" + letra + ", localidad=" + localidad + ", numero=" + numero + ", piso=" + piso + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Direcciones that = (Direcciones) o;
		return idDireccion == that.idDireccion && numero == that.numero && calle.equals(that.calle) && codigoPostal.equals(that.codigoPostal) && letra.equals(that.letra) && localidad.equals(that.localidad) && piso.equals(that.piso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDireccion, calle, codigoPostal, letra, localidad, numero, piso);
	}
}