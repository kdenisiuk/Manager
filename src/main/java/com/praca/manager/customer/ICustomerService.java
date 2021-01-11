package com.praca.manager.customer;

import java.util.List;

public interface ICustomerService{

    List<Customer> findByPhoneNumberEqualsTo(String phoneNumber, String owner);
}