package com.foxmonshop.backend.feature.delivery.dao;

import com.foxmonshop.backend.feature.delivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
