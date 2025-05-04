package com.kgalarza.hexagonal_architecture.infrastructure.port.in.mapper;

import com.kgalarza.hexagonal_architecture.domain.model.Customer;
import com.kgalarza.hexagonal_architecture.infrastructure.port.in.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDTO toDto(Customer customer);
    Customer toDomain(CustomerDTO customerDTO);

}
