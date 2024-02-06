package com.foxmonshop.backend.feature.order.dao;

import com.foxmonshop.backend.feature.coupon.dao.CouponService;
import com.foxmonshop.backend.feature.coupon.domain.Coupon;
import com.foxmonshop.backend.feature.order.domain.Order;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final CouponService couponService;

    public Order order() {
        // 10.000
        final Order order = Order
            .builder()
            .price(1_000)
            .build();

        Coupon coupon = this.couponService.findById(1L);

        order.applyCoupon(coupon);

        return this.orderRepository.save(order);
    }

    public Order findById(Long id) {
        return this.orderRepository.findById(id).get();
    }
}
