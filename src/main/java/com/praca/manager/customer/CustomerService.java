package com.praca.manager.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).get();
    }

    public Customer getReferenceId(Integer id){
        return customerRepository.getOne(id);
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