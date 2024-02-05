package com.foxmonshop.backend.feature.delivery.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.foxmonshop.backend.feature.delivery.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "delivery_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private DeliveryStatus status;

    @Transient
    private DeliveryStatus lastStatus;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false, updatable = false)
    private Delivery delivery;

    @Builder
    public DeliveryLog(final DeliveryStatus deliveryStatus, final Delivery delivery) {
        this.setStatus(deliveryStatus);

        this.delivery = delivery;
    }

    private void setStatus(final DeliveryStatus status) {
        switch (status) {
            case DELIVERING:
                this.delivering();
                break;

            case COMPLETED:
                this.completed();
                break;

            case CANCELED:
                this.cancel();
                break;

            case PENDING:
                this.pending();
                break;

            default:
                throw new IllegalArgumentException(status.name() + " is not found");
        }
    }

    private void pending() {
        this.status = DeliveryStatus.PENDING;
    }

    private void cancel() {
        this.status = DeliveryStatus.CANCELED;
    }

    private void completed() {
        this.status = DeliveryStatus.COMPLETED;
    }

    private void delivering() {
        this.status = DeliveryStatus.DELIVERING;
    }

}
