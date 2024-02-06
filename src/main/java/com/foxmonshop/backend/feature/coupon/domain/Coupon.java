package com.foxmonshop.backend.feature.coupon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foxmonshop.backend.feature.order.domain.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "discount_amount")
    private double discountAmount;

    @Column(name = "use")
    private boolean use;

    @JsonIgnore
    @OneToOne(mappedBy = "coupon")
    private Order order;

    @Builder
    public Coupon(double discountAmount) {
        this.discountAmount = discountAmount;
        this.use = false;
    }

    public void use(final Order order) {
        this.order = order;

        this.use = true;
    }
}
