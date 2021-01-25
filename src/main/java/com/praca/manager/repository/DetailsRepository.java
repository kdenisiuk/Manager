package com.praca.manager.repository;

import com.praca.manager.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, Integer> {

    @Query("from Details where customer.customerId = :customerId")
    List<Details> findByCustomerId(@Param("customerId") Integer id);
}