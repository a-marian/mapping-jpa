package com.mapping.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID>, QueryByExampleExecutor<T> {

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    T getReferenceById(ID id);

    List<T> findAllById(Iterable<ID> ids);

    long count();

    void delete(T entity);

    void deleteById(ID id);

    void flush();


}
