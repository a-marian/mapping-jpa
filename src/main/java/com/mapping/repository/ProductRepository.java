package com.mapping.repository;

import com.mapping.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product, Long>,
                                        BaseHibernateRepository<Product> {

    @Query(value = "SELECT * FROM Product p WHERE p.price < 1000.00 AND p.description = :kenzo", nativeQuery = true)
    List<Product> getProductByBrandDescAndPrice(@Param("kenzo") String description);
}
