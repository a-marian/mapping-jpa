package com.mapping.repository;

import com.mapping.model.Bill;
import com.mapping.record.BillRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends BaseRepository<Bill, Long>{

    @Query(value = "{ 'billData': { '$lte' : ?0 }}")
    List<BillRecord> getBillsGeneratedBeforeDate(Date billData);
}
