package com.kgalarza.hexagonal_architecture.infrastructure.port.in.handler;


import com.kgalarza.hexagonal_architecture.domain.port.in.ICustomerServicePort;
import com.kgalarza.hexagonal_architecture.infrastructure.port.in.dto.CustomerDTO;
import com.kgalarza.hexagonal_architecture.infrastructure.port.in.mapper.ICustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerHandler {

    private final ICustomerServicePort customerServicePort;
    private final ICustomerMapper customerMapper;

    public CustomerHandler(ICustomerServicePort customerServicePort, ICustomerMapper customerMapper) {
        this.customerServicePort = customerServicePort;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO findCustomerById(Long id) {
        return customerMapper.toDto(customerServicePort.getCustomerById(id));
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerServicePort.getAllCustomers()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return customerMapper.toDto(customerServicePort.saveCustomer(customerMapper.toDomain(customerDTO)));
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return customerMapper.toDto(customerServicePort.updateCustomer(customerMapper.toDomain(customerDTO)));
    }

    public void deleteCustomerById(Long id) {
        customerServicePort.deleteCustomer(id);
    }

}
