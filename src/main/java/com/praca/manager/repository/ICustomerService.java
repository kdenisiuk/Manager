package com.praca.manager.repository;

import com.praca.manager.entity.Customer;

import java.util.List;

public interface ICustomerService{

    List<Customer> findByPhoneNumberEqualsTo(String phoneNumber, String owner);
}