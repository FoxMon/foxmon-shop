package com.foxmonshop.backend.feature.order.domain;

import com.foxmonshop.backend.feature.coupon.domain.Coupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", nullable = false)
    private Coupon coupon;

    @Builder
    public Order(double price) {
        this.price = price;
    }

    public void applyCoupon(final Coupon coupon) {
        this.coupon = coupon;

        coupon.use(this);

        price -= coupon.getDiscountAmount();
    }
}
