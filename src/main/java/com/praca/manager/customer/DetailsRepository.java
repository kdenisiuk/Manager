package com.praca.manager.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {

    @Query("from Details where customer.customer_id = :customerId")
    List<Details> findByCustomerId(@Param("customerId") Integer id);

}