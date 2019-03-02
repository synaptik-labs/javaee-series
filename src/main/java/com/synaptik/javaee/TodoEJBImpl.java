package com.synaptik.javaee;

import com.synaptik.javaee.entities.Todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TodoEJBImpl implements TodoEJB {
	@PersistenceContext
	EntityManager em;

	public List<Todo> findAll() {
		Query q = em.createQuery("SELECT t FROM Todo t");
		return q.getResultList();
	}

	public void create(Todo incoming) {
		em.persist(incoming);
	}

	public void update(Long id, Todo incoming) {
		Todo entity = em.find(Todo.class, id);
		entity.setDescription(incoming.getDescription());
		em.merge(entity);
	}

	public void remove(Long id) {
		Todo entity = em.find(Todo.class, id);
		em.remove(entity);
	}
}
