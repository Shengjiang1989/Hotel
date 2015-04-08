package edu.neu.cs5200.hotel.main.basedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BaseDAO<T> {

	EntityManagerFactory factory;
	EntityManager em;
	
	public BaseDAO(){
		super();
		this.factory = Persistence.createEntityManagerFactory("HotelBooking");
		this.em = factory.createEntityManager();
	}
	
	public T create(T object) {
		em.getTransaction().begin();
		em.persist(object);
		em.flush();
		em.getTransaction().commit();
		return object;
	}
	
	public T update(T object) {
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		return object;
	}
	
	public Boolean delete(T object) {
		if (em.contains(object)) {
			em.remove(object);
			return true;
		}else return false;
	}
	
	public T getById(Class<T> clz, Integer id) {
		return em.find(clz, id);
	}
	
	public List<T> query(Class<T> clz, String scope, List paras) {
		Query query = em.createQuery("FROM" + clz + "WHERE" + scope);
		int parameterIndex = 0;
        if (paras != null && paras.size() > 0) {  
            for (Object obj : paras) {  
                query.setParameter(parameterIndex++, obj);  
            }  
        }
        return query.getResultList();
	}
	
	public List<T> executeNativeQuery(String nameNativeQuery, List parasName, List paras) {
		Query query = em.createNativeQuery(nameNativeQuery);
		if (paras != null && paras.size() > 0) {  
        	int i = 0;
            for (Object obj : paras) {
            	query.setParameter((String)parasName.get(i), obj);  
            	++i;
            }  
        }  
        
		return query.getResultList();
	}
}
