package com.java.coupon.repository;

import com.java.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Query(value = "SELECT * from coupon WHERE cp_name REGEXP :regexp", nativeQuery = true)
    List<Coupon> findAllOnlyKoreanAndExmark(String regexp);
}
