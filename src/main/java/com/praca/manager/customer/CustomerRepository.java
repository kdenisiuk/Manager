package com.praca.manager.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("from Customer where (phoneNumber = :phoneNumber) or (owner = :owner)")
    List<Customer> findByPhoneNumberEqualsTo(@Param("phoneNumber") String phoneNumber,@Param("owner") String owner);
}