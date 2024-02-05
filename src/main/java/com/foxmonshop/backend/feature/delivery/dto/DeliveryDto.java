package com.foxmonshop.backend.feature.delivery.dto;

import com.foxmonshop.backend.feature.delivery.domain.Delivery;
import com.foxmonshop.backend.feature.delivery.domain.DeliveryLog;
import com.foxmonshop.backend.feature.delivery.enums.DeliveryStatus;
import com.foxmonshop.backend.feature.user.domain.Address;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class DeliveryDto {
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreationRequest {
        private Address address;

        @Builder
        public CreationRequest(Address address) {
            this.address = address;
        }

        public Delivery toEntity() {
            return Delivery
                .builder()
                .address(this.address)
                .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateRequest {
        private DeliveryStatus deliveryStatus;

        @Builder
        public UpdateRequest(DeliveryStatus deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
    }

    public static class LogResponse {
        private DeliveryStatus deliveryStatus;

        public LogResponse(DeliveryLog deliveryLog) {
            this.deliveryStatus = deliveryLog.getStatus();
        }
    }

    public static class Response {
        private Address address;

        private List<LogResponse> logs;

        public Response(final Delivery delivery) {
            this.address = delivery.getAddress();

            this.logs = delivery
                .getLogs()
                .parallelStream()
                .map(LogResponse::new)
                .collect(Collectors.toList());
        }
    }
}
