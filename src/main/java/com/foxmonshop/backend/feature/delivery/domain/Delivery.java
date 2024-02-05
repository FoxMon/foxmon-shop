package com.foxmonshop.backend.feature.delivery.domain;

import com.foxmonshop.backend.feature.delivery.enums.DeliveryStatus;
import com.foxmonshop.backend.feature.user.domain.Address;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "delivery")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Address address;

    @OneToMany(
        mappedBy = "delivery",
        cascade = CascadeType.PERSIST,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    private List<DeliveryLog> logs = new ArrayList<>();

    @Builder
    public Delivery(Address address) {
        this.address = address;
    }

    public void addLog(DeliveryStatus deliveryStatus) {
        this.logs.add(this.buildLog(deliveryStatus));
    }

    private DeliveryLog buildLog(DeliveryStatus deliveryStatus) {
        return DeliveryLog
            .builder()
            .deliveryStatus(deliveryStatus)
            .delivery(this)
            .build();
    }
}
