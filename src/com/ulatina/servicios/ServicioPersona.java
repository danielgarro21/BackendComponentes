package com.ulatina.servicios;

import java.util.List;

import com.ulatina.entidades.Persona;
import com.ulatina.util.HibernateUtil;

public class ServicioPersona extends HibernateUtil {
	public void insertarPublicacion(Persona persona) throws Exception {
		super.insert(persona);
	}
	
	public Persona findbyId(int id) {
		Persona persona = super.em.find(Persona.class, new Integer(id));
		if (persona != null) {
			System.out.println("Nombre del Dato Almacenado y Buscado por PK: " + persona.getNombre());
			return persona;
		} else {
			System.out.println("No se encontro un rol con el id indicado");
			return null;
		}
	}
	
	public Persona buscarPorId(int id) throws Exception {
		Persona persona = (Persona) super.getEm().createNamedQuery("Persona.findByPrimaryKey").setParameter("id", new Integer(id))
				.getSingleResult();
		return persona;
	}
	
	public List<Persona> getListaPersona() {
		String jpql = "SELECT t FROM " + Persona.class.getSimpleName() + " t";
		List<Persona> listaPersona = em.createQuery(jpql, Persona.class).getResultList();
		if (listaPersona != null) {
			System.out.println("Lista encontrada");
			return listaPersona;
		} else {
			System.out.println("Lista no encontrada");
			return null;
		}
	}

	
	public Persona buscarPorCorreo(String correo) throws Exception {
		Persona persona = (Persona) super.getEm().createNamedQuery("Persona.findByCorreo").setParameter("correo", new String(correo))
				.getSingleResult();
		return persona;
	}
}
