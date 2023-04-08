package com.mapping.repository;

import com.mapping.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long>,
        BaseHibernateRepository<Customer>{

    @Query(value = "SELECT c FROM Customer c WHERE c.identifier IN :identifiers")
    List<Customer> findCustomersByIdentifierList(@Param("identifiers") Collection<String> identifiers);

    Customer findByIdentifier(String identifier);
}
