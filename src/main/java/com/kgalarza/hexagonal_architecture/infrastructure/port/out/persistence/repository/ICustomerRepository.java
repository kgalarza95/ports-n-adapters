package com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.repository;

import com.kgalarza.hexagonal_architecture.infrastructure.port.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
