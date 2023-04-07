package com.mapping.repository;

import com.mapping.model.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long> {

    @Query("SELECT c FROM Cashier c WHERE c.status = 1")
    List<Cashier> findAllCashiers();



}
