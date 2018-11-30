package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the multimedia database table.
 * 
 */
@Entity
@NamedQuery(name="Multimedia.findAll", query="SELECT m FROM Multimedia m")
public class Multimedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idmultimedia;

	@Lob
	private String url;

	//bi-directional many-to-many association to Publicacion
	@ManyToMany
	@JoinTable(
		name="multimediaporpublicacion"
		, joinColumns={
			@JoinColumn(name="Multimedia")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Publicacion")
			}
		)
	private List<Publicacion> publicacions;

	public Multimedia() {
	}

	public int getIdmultimedia() {
		return this.idmultimedia;
	}

	public void setIdmultimedia(int idmultimedia) {
		this.idmultimedia = idmultimedia;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

}