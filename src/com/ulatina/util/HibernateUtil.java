package com.ulatina.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class HibernateUtil {

	private EntityManagerFactory entityManagerFactory = null;
	protected EntityManager em = null;

	public void insert(Object obj) throws Exception {
		getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.flush();
		em.refresh(obj);
		em.getTransaction().commit();
	}
	
	public void update(Object obj) throws Exception {
		getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.flush();
		em.refresh(obj);
	}
	
	public void delete(Object obj) throws Exception {
		
	}
	

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {

		if (this.em == null || !this.em.isOpen()) {
			startEntityManagerFactory();
		}
		return this.em;
	}

	public void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("RedSocialComponentes");
				em = entityManagerFactory.createEntityManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void stopEntityManagerFactory() {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
	}
}