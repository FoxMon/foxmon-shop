package com.foxmonshop.backend.feature.order.dao;

import com.foxmonshop.backend.feature.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
