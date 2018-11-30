package com.ulatina.servicios;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ulatina.entidades.Rol;
import com.ulatina.util.HibernateUtil;

public class ServicioRol extends HibernateUtil {

	public void insertarPublicacion(Rol rol) throws Exception {
		super.insert(rol);
	}
	
	public void editarRol(Rol rol) throws Exception {
		Rol updateRol = (Rol) super.getEm().createNamedQuery("Rol.findByPrimaryKey").setParameter("id", new Integer(rol.getIdRol()))
				.getSingleResult();
		if (updateRol != null) {
			super.update(rol);
		} else {
			System.out.println("ID no coincide");
		}
	}

	public Rol findbyId(int id) {
		Rol rol = super.em.find(Rol.class, new Integer(id));
		if (rol != null) {
			System.out.println("Nombre del Dato Almacenado y Buscado por PK: " + rol.getNombre());
			return rol;
		} else {
			System.out.println("No se encontro un rol con el id indicado");
			return null;
		}
	}

	public List<Rol> getListaRol() {
		String jpql = "SELECT t FROM " + Rol.class.getSimpleName() + " t";
		List<Rol> listaRol = em.createQuery(jpql, Rol.class).getResultList();
		if (listaRol != null) {
			System.out.println("Lista encontrada");
			return listaRol;
		} else {
			System.out.println("Lista no encontrada");
			return null;
		}

	}

	public List<Rol> findAllByNombre(String nombre) throws Exception {
		TypedQuery<Rol> query = super.em.createNamedQuery("Rol.findAllNombre", Rol.class);
		query.setParameter("nombreParam", "%" + nombre + "%");
		return query.getResultList();
	}

	public Rol buscarPorId(int id) throws Exception {
		Rol rol = (Rol) super.getEm().createNamedQuery("Rol.findByPrimaryKey").setParameter("id", new Integer(id))
				.getSingleResult();
		return rol;
	}
}
