// OrderRepository.java
package com.example.roadsideeatery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.roadsideeatery.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

