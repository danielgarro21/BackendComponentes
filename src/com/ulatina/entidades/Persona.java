package com.ulatina.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p"),
		@NamedQuery(name = "Persona.findAllCorreo", query = "SELECT p FROM Persona p WHERE p.correo LIKE :correoParam ORDER BY p.correo"),
		@NamedQuery(name = "Persona.findByPrimaryKey", query = "SELECT p FROM Persona p WHERE p.idPersona = :id"),
		@NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
})

@NamedNativeQueries({
	@NamedNativeQuery(name = "Persona.findAllSQL", query = "SELECT id, correo, nombre FROM Persona", resultClass = Persona.class),
	@NamedNativeQuery(name = "Persona.findAllSQLWithParam", query = "SELECT * FROM Persona WHERE correo LIKE :correoParam ORDER BY correo", resultClass = Persona.class) })
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPersona;

	private String apellido;

	private String correo;

	private String fbToken;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	private String segundoApellido;

	private String sexo;

	private String telefono;

	//bi-directional many-to-one association to Correosenviar
	@OneToMany(mappedBy="personaBean")
	private List<Correosenviar> correosenviars;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="rolporpersona"
		, joinColumns={
			@JoinColumn(name="Persona")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Rol")
			}
		)
	private List<Rol> rols;

	//bi-directional many-to-one association to Pregunta
	@OneToMany(mappedBy="persona")
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="personaBean")
	private List<Publicacion> publicacions;

	//bi-directional many-to-one association to ListaBot
	@OneToMany(mappedBy="persona")
	private List<ListaBot> listaBots;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFbToken() {
		return this.fbToken;
	}

	public void setFbToken(String fbToken) {
		this.fbToken = fbToken;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Correosenviar> getCorreosenviars() {
		return this.correosenviars;
	}

	public void setCorreosenviars(List<Correosenviar> correosenviars) {
		this.correosenviars = correosenviars;
	}

	public Correosenviar addCorreosenviar(Correosenviar correosenviar) {
		getCorreosenviars().add(correosenviar);
		correosenviar.setPersonaBean(this);

		return correosenviar;
	}

	public Correosenviar removeCorreosenviar(Correosenviar correosenviar) {
		getCorreosenviars().remove(correosenviar);
		correosenviar.setPersonaBean(null);

		return correosenviar;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setPersona(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setPersona(null);

		return pregunta;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setPersonaBean(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setPersonaBean(null);

		return publicacion;
	}

	public List<ListaBot> getListaBots() {
		return this.listaBots;
	}

	public void setListaBots(List<ListaBot> listaBots) {
		this.listaBots = listaBots;
	}

	public ListaBot addListaBot(ListaBot listaBot) {
		getListaBots().add(listaBot);
		listaBot.setPersona(this);

		return listaBot;
	}

	public ListaBot removeListaBot(ListaBot listaBot) {
		getListaBots().remove(listaBot);
		listaBot.setPersona(null);

		return listaBot;
	}

}