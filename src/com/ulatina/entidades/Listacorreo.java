package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the listacorreos database table.
 * 
 */
@Entity
@Table(name="listacorreos")
@NamedQuery(name="Listacorreo.findAll", query="SELECT l FROM Listacorreo l")
public class Listacorreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idListaCorreos;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to Correo
	@ManyToMany(mappedBy="listacorreos")
	private List<Correo> correos;

	//bi-directional many-to-many association to Correosenviar
	@ManyToMany
	@JoinTable(
		name="correosenviarporlistacorreos"
		, joinColumns={
			@JoinColumn(name="ListaCorreos")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CorreosEnviar")
			}
		)
	private List<Correosenviar> correosenviars;

	public Listacorreo() {
	}

	public int getIdListaCorreos() {
		return this.idListaCorreos;
	}

	public void setIdListaCorreos(int idListaCorreos) {
		this.idListaCorreos = idListaCorreos;
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

	public List<Correo> getCorreos() {
		return this.correos;
	}

	public void setCorreos(List<Correo> correos) {
		this.correos = correos;
	}

	public List<Correosenviar> getCorreosenviars() {
		return this.correosenviars;
	}

	public void setCorreosenviars(List<Correosenviar> correosenviars) {
		this.correosenviars = correosenviars;
	}

}