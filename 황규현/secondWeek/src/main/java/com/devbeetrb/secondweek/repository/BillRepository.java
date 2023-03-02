package com.devbeetrb.secondweek.repository;

import com.devbeetrb.secondweek.persistence.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
