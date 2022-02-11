package com.crud.bagus.repository;

import com.crud.bagus.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    Customer findById (long id);
}
