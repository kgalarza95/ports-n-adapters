package com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.adapter;

import com.kgalarza.hexagonal_architecture.domain.model.Customer;
import com.kgalarza.hexagonal_architecture.domain.port.out.ICustomerRepositoryPort;
import com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.entity.CustomerEntity;
import com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.mapper.ICustomerRepositoryMapper;
import com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryAdapter implements ICustomerRepositoryPort {

    private final ICustomerRepository customerRepository;
    private final ICustomerRepositoryMapper customerRepositoryMapper;

    public CustomerRepositoryAdapter(ICustomerRepository customerRepository, ICustomerRepositoryMapper customerRepositoryMapper) {
        this.customerRepository = customerRepository;
        this.customerRepositoryMapper = customerRepositoryMapper;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerRepositoryMapper::toDomain);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerRepositoryMapper::toDomain)
                .toList();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = customerRepository.save(customerRepositoryMapper.toEntity(customer));
        return customerRepositoryMapper.toDomain(customerEntity);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepositoryMapper.toDomain(customerRepository.save(customerRepositoryMapper.toEntity(customer)));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
