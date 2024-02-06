package com.foxmonshop.backend.feature.coupon.dao;

import com.foxmonshop.backend.feature.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
