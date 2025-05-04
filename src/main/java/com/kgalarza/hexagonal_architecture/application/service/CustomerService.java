package com.kgalarza.hexagonal_architecture.application.service;

import com.kgalarza.hexagonal_architecture.application.exception.CustomerNotFoundException;
import com.kgalarza.hexagonal_architecture.domain.model.Customer;
import com.kgalarza.hexagonal_architecture.domain.port.in.ICustomerServicePort;
import com.kgalarza.hexagonal_architecture.domain.port.out.ICustomerRepositoryPort;
import com.kgalarza.hexagonal_architecture.domain.port.out.ILogBusMessagePort;

import java.util.List;

public class CustomerService implements ICustomerServicePort {

    private final ICustomerRepositoryPort customerRepositoryPort;
    private final ILogBusMessagePort logBusMessagePort;

    public CustomerService(ICustomerRepositoryPort customerRepositoryPort, ILogBusMessagePort logBusMessagePort) {
        this.customerRepositoryPort = customerRepositoryPort;
        this.logBusMessagePort = logBusMessagePort;
    }

    @Override
    public Customer getCustomerById(Long id) {
        logBusMessagePort.sendMessage("Fetching customer with ID: " + id);
        return customerRepositoryPort.getCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        logBusMessagePort.sendMessage("Fetching all customers");
        return customerRepositoryPort.getAllCustomers();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        logBusMessagePort.sendMessage("Saving customer: " + customer);
        return customerRepositoryPort.saveCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        logBusMessagePort.sendMessage("Updating customer: " + customer);
        return customerRepositoryPort.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        logBusMessagePort.sendMessage("Deleting customer with ID: " + id);
        customerRepositoryPort.deleteCustomer(id);
    }
}
