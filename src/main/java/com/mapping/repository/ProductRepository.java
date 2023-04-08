package com.mapping.repository;

import com.mapping.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long>,
                                        BaseHibernateRepository<Product> {

    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts(Sort sort);

    @Query(
            value = "SELECT * FROM Product ORDER BY description",
            countQuery = "SELECT count(*) FROM Product",
            nativeQuery = true)
    Page<Product> findAllProductsWithPaginationNative(Pageable pageable);

    @Query("SELECT p FROM Product p ORDER BY productCode")
    Page<Product> findAllProductWithPagination(Pageable pageable);

    @Query("""
            SELECT p FROM Product p
             WHERE UPPER(p.productName) LIKE UPPER(CONCAT('%', COALESCE(:searchRequest, ''), '%'))
             AND UPPER(p.description) LIKE UPPER(CONCAT('%', COALESCE(:description, ''), '%'))
             AND p.price BETWEEN :priceLow AND :priceHigh
            """)
    Page<Product> findAllProductsBySearchModel(
            Pageable pageable,
            @Param("searchRequest") String searchRequest,
            @Param("description") String description,
            @Param("priceLow") Double priceLow,
            @Param("priceHigh") Double priceHigh
    );


}
