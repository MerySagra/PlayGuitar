package com.shop.playguitar.modelo.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the usuarios_direcciones database table.
 *
 */

	@Entity
	@Table(name = "USUARIOS_DIRECCIONES")
	public class UsuarioDirecciones implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "ID_USUARIO")
	    private Usuario usuario;
	    
	    @ManyToOne
	    @JoinColumn(name = "ID_DIRECCION")
	    private Direcciones direccion;
	    
	    public UsuarioDirecciones() {
	    	
	    }

		//Getters y Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Direcciones getDireccion() {
			return direccion;
		}

		public void setDireccion(Direcciones direccion) {
			this.direccion = direccion;
		}

		//To String

		@Override
		public String toString() {
			return "UsuarioDireccione [id=" + id + ", usuario=" + usuario + ", direccion=" + direccion + "]";
		}

		//Equals & Hash code

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			UsuarioDirecciones that = (UsuarioDirecciones) o;
			return getId().equals(that.getId()) && getUsuario().equals(that.getUsuario()) && getDireccion().equals(that.getDireccion());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getId(), getUsuario(), getDireccion());
		}
	}



