package com.mapping.repository;

import com.mapping.model.Computer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface ComputerRepository  extends BaseRepository<Computer, Long>,
        BaseHibernateRepository<Computer> {

    Computer persist(Computer computer);

    @Query("SELECT c FROM Computer c WHERE c.brand='Apple' ")
    Collection<Computer> findAllAppleComputers();

    @Query(value= """
            SELECT *
            FROM computer
            WHERE brand = 'Apple';
            """, nativeQuery = true)
    List<Computer> findAllAppleComputersNative();

}
