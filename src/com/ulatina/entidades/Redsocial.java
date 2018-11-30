package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the redsocial database table.
 * 
 */
@Entity
@NamedQuery(name="Redsocial.findAll", query="SELECT r FROM Redsocial r")
public class Redsocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRedSocial;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="redsocial")
	private List<Publicacion> publicacions;

	public Redsocial() {
	}

	public int getIdRedSocial() {
		return this.idRedSocial;
	}

	public void setIdRedSocial(int idRedSocial) {
		this.idRedSocial = idRedSocial;
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

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setRedsocial(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setRedsocial(null);

		return publicacion;
	}

}