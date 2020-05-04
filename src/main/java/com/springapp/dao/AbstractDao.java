package com.springapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public Boolean persist(T entity) {
		try {
			getSession().persist(entity);
			return true;
		} catch (SessionException s) {
			s.printStackTrace();
			return false;
		}
	}
	public Boolean save_update(T entity) {
		try {
			getSession().saveOrUpdate(entity);
			return true;
		} catch (SessionException s) {
			s.printStackTrace();
			return false;
		}
	}


	public Boolean delete(T entity) {
        try {
		    getSession().delete(entity);
		    return true;
        } catch (SessionException s) {
            s.printStackTrace();
            return false;
        }
	}

	public Boolean update(T entity) {
		try {
			getSession().update(entity);
			return true;
		} catch (SessionException s) {
			s.printStackTrace();
			return false;
		}
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

}
