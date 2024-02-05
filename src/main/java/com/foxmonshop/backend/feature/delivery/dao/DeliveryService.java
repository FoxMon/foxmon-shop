package com.foxmonshop.backend.feature.delivery.dao;

import com.foxmonshop.backend.feature.delivery.domain.Delivery;
import com.foxmonshop.backend.feature.delivery.dto.DeliveryDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery createDelivery(DeliveryDto.CreationRequest dto) {
        final Delivery delivery = dto.toEntity();

        return this.deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Long id, DeliveryDto.UpdateRequest dto) {
        final Delivery delivery = this.findById(id);

        delivery.addLog(dto.getDeliveryStatus());

        return delivery;
    }

    public Delivery findById(Long id) {
        final Optional<Delivery> delivery = this.deliveryRepository.findById(id);

        return delivery.get();
    }

    public void deleteDelivery(Long id) {
        this.deliveryRepository.deleteById(id);
    }
}
