package com.mapping.repository;

import com.mapping.model.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends BaseRepository<Bill, Long>{

    List<Bill> findBillsByBillDate(Date billDate);

    List<Bill> findAllByBillDateBetween(Date startBillDate, Date endBillDate);

    @Query("select b from Bill b where b.billDate <= :billDate")
    List<Bill> findAllWithBillDateBefore(@Param("billDate") Date billDate);
}
