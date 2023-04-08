package com.mapping.repository;

import com.mapping.model.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long>, BaseHibernateRepository<Cashier> {
    /**spilca-C29Fspilca-4941
     */
    @Modifying
    @Query("UPDATE Cashier c SET c.status = :status WHERE c.mail = :mail")
    int updateCashierSetStatusByMail(@Param("status") boolean status, @Param("mail") String mail);

    @Modifying
    @Query(value = "UPDATE Cashier SET status = ? WHERE mail = ? ", nativeQuery = true)
    int updateCashierSetStatusByMailNative(boolean status, String mail);



    @Query(value="SELECT * FROM Cashier WHERE mail like '%gmail.com'", nativeQuery = true)
    List<Cashier> findAllCashiersByMailGmail();

}
