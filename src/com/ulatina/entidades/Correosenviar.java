package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the correosenviar database table.
 * 
 */
@Entity
@NamedQuery(name="Correosenviar.findAll", query="SELECT c FROM Correosenviar c")
public class Correosenviar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCorreosEnviar;

	private String asunto;

	private String contenido;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="Persona")
	private Persona personaBean;

	//bi-directional many-to-many association to Listacorreo
	@ManyToMany(mappedBy="correosenviars")
	private List<Listacorreo> listacorreos;

	public Correosenviar() {
	}

	public int getIdCorreosEnviar() {
		return this.idCorreosEnviar;
	}

	public void setIdCorreosEnviar(int idCorreosEnviar) {
		this.idCorreosEnviar = idCorreosEnviar;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Persona getPersonaBean() {
		return this.personaBean;
	}

	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	public List<Listacorreo> getListacorreos() {
		return this.listacorreos;
	}

	public void setListacorreos(List<Listacorreo> listacorreos) {
		this.listacorreos = listacorreos;
	}

}