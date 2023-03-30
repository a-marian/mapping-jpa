package com.mapping.repository;

import java.util.List;

public interface BaseHibernateRepository<T> {

    /** The persist methods are meant to save the newly created entities */
    <S extends T> S persist(S entity);
    <S extends T> S persistAndFlush(S entity);
    <S extends T>List<S> persistAll(Iterable<S> entities);

    <S extends T>List<S> persistAllAndFlush(Iterable<S> entities);

    /** The update methods are meant to force the synchronization of
     * the detached entity state changes */
    <S extends T> S update(S entity);
    <S extends T> S updateAndFlush(S entity);

}
