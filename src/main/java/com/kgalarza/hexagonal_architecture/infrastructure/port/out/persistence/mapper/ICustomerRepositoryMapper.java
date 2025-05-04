package com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.mapper;


import com.kgalarza.hexagonal_architecture.domain.model.Customer;
import com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerRepositoryMapper {

    Customer toDomain(CustomerEntity customerEntity);

    CustomerEntity toEntity(Customer customer);
}
