package com.kgalarza.hexagonal_architecture.domain.port.in;

import com.kgalarza.hexagonal_architecture.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServicePort {

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}
