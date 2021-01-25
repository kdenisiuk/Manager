package com.praca.manager.service;

import com.praca.manager.repository.CustomerRepository;
import com.praca.manager.repository.ICustomerService;
import com.praca.manager.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> listAll() {

        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id) {

        return customerRepository.findById(id).get();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByPhoneNumberEqualsTo(String phoneNumber, String owner) {
        var customers = (List<Customer>) customerRepository.findByPhoneNumberEqualsTo(phoneNumber, owner);

        return customers;
    }
}