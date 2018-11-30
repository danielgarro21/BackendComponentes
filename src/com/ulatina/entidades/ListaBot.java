package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the listaBot database table.
 * 
 */
@Entity
@NamedQuery(name="ListaBot.findAll", query="SELECT l FROM ListaBot l")
public class ListaBot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idBot;

	private String descripcion;

	private String nombreBot;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	private Persona persona;

	public ListaBot() {
	}

	public String getIdBot() {
		return this.idBot;
	}

	public void setIdBot(String idBot) {
		this.idBot = idBot;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreBot() {
		return this.nombreBot;
	}

	public void setNombreBot(String nombreBot) {
		this.nombreBot = nombreBot;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}