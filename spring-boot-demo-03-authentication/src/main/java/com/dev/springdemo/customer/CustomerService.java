package com.dev.springdemo.customer;

import com.dev.springdemo.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sunitc on 4/19/18.
 */
@Service
public class CustomerService {

    //Autowiring the repository
    @Autowired
    private CustomerRepository customerRepository;

    //Get customer by Id
    public Optional<Customer> getCustomerById(Long customerId) {
       return customerRepository.findById(customerId);
    }

    //Create the customer
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    //Update the customer
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    //Find all customers by name
    public List<Customer> findByName(String name){
        return customerRepository.findAllByFirstNameContainingOrLastNameContaining(name, name);
    }

    //Paging implementation of findAll
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
