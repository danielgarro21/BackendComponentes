package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
		@NamedQuery(name = "Rol.findAllNombre", query = "SELECT d FROM Rol d WHERE d.nombre LIKE :nombreParam ORDER BY d.nombre"),
		@NamedQuery(name = "Rol.findByPrimaryKey", query = "SELECT e FROM Rol e WHERE e.idRol = :id") })

@NamedNativeQueries({
		@NamedNativeQuery(name = "Rol.findAllSQL", query = "SELECT id, nombre, descripcion FROM Rol", resultClass = Rol.class),
		@NamedNativeQuery(name = "Rol.findAllSQLWithParam", query = "SELECT * FROM Rol WHERE nombre LIKE :nombreParam ORDER BY nombre", resultClass = Rol.class) })
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRol;

	private String descripcion;

	private String nombre;

	// bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy = "rols")
	private List<Persona> personas;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
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

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}