package com.ulatina.servicios;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ulatina.entidades.Publicacion;
import com.ulatina.util.HibernateUtil;

public class ServicioPublicacion extends HibernateUtil {
	public void insertarPublicacion(Publicacion publicacion) throws Exception {
		super.insert(publicacion);
	}
	
	public void updatePublicacion(Publicacion publicacion) throws Exception {
		super.update(publicacion);
	}

	public Publicacion findbyId(int id) {
		Publicacion publicacion = super.em.find(Publicacion.class, new Integer(id));
		if (publicacion != null) {
			System.out.println("Nombre del Dato Almacenado y Buscado por PK: " + publicacion.getTitulo());
			return publicacion;
		} else {
			return null;
		}	
	}

	public Publicacion buscarPorId(int id) throws Exception {
		Publicacion publicacion = (Publicacion) super.getEm().createNamedQuery("Publicacion.findPK")
				.setParameter("idPublicacion", new Integer(id)).getSingleResult();
		return publicacion;
	}
	
	public List<Publicacion> getListaRol() {
		String jpql = "SELECT t FROM " + Publicacion.class.getSimpleName() + " t";
		List<Publicacion> listaPublicacion = em.createQuery(jpql, Publicacion.class).getResultList();
		if (listaPublicacion != null) {
			System.out.println("Lista encontrada");
			return listaPublicacion;
		} else {
			System.out.println("Lista no encontrada");
			return null;
		}

	}

	public List<Publicacion> findAllByNombre(String titulo) throws Exception {
		TypedQuery<Publicacion> query = super.em.createNamedQuery("Publicacion.findAllTitulo", Publicacion.class);
		query.setParameter("nombreParam", "%" + titulo + "%");
		return query.getResultList();
	}
}
