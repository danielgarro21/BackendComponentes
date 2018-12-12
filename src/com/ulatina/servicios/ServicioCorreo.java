package com.ulatina.servicios;

import javax.persistence.TypedQuery;

import java.util.List;


import com.ulatina.entidades.Correo;
import com.ulatina.util.HibernateUtil;

public class ServicioCorreo extends HibernateUtil {
	public void insertarCorreo(Correo correo) throws Exception {
		super.insert(correo);
	}
	
	public void updateCorreo(Correo correo) throws Exception {
		super.update(correo);
	}

	public Correo findbyId(int id) {
		Correo correo = super.em.find(Correo.class, new Integer(id));
		if (correo != null) {
			System.out.println("Nombre del Dato Almacenado y Buscado por PK: " + correo.getCorreo());
			return correo;
		} else {
			return null;
		}	
	}

	public Correo buscarPorId(int id) throws Exception {
		Correo correo = (Correo) super.getEm().createNamedQuery("Correo.findPK")
				.setParameter("idCorreo", new Integer(id)).getSingleResult();
		return correo;
	}
	
	public List<Correo> getListaRol() {
		String jpql = "SELECT t FROM " + Correo.class.getSimpleName() + " t";
		List<Correo> listaCorreo = em.createQuery(jpql, Correo.class).getResultList();
		if (listaCorreo != null) {
			System.out.println("Lista encontrada");
			return listaCorreo;
		} else {
			System.out.println("Lista no encontrada");
			return null;
		}

	}

	public List<Correo> findAllByNombre(String correo) throws Exception {
		TypedQuery<Correo> query = super.em.createNamedQuery("Correo.findAllCorreo", Correo.class);
		query.setParameter("nombreParam", "%" + correo + "%");
		return query.getResultList();
	}
}
