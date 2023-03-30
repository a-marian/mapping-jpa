package com.mapping.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BaseHibernateRepositoryImpl<T> implements BaseHibernateRepository<T>{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public <S extends T> S persist(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends T> S persistAndFlush(S entity) {
        persist(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public <S extends T> List<S> persistAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        for(S entity : entities){
            result.add(persist(entity));
        }
        return result;
    }

    @Override
    public <S extends T> List<S> persistAllAndFlush(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        for(S entity : entities){
            result.add(persist(entity));
        }
        entityManager.flush();
        return result;
    }

    protected Session session() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public <S extends T> S update(S entity) {
       session().update(entity);
       return entity;
    }

    @Override
    public <S extends T> S updateAndFlush(S entity) {
        session().update(entity);
        entityManager.flush();
        return entity;
    }
}
