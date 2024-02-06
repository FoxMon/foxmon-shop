package com.foxmonshop.backend.feature.coupon.dao;

import com.foxmonshop.backend.feature.coupon.domain.Coupon;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public Coupon findById(Long id) {
        return couponRepository.findById(id).get();
    }
}
