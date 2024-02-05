package com.foxmonshop.backend.feature.delivery;

import com.foxmonshop.backend.feature.delivery.dao.DeliveryService;
import com.foxmonshop.backend.feature.delivery.dto.DeliveryDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;

    @PostMapping("/delivery")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DeliveryDto.Response createDelivery(@RequestBody final DeliveryDto.CreationRequest dto) {
        return new DeliveryDto.Response(this.deliveryService.createDelivery(dto));
    }

    @GetMapping(value = "/delivery/${id}")
    @ResponseStatus(value = HttpStatus.OK)
    public DeliveryDto.Response getDelivery(@PathVariable final Long id) {
        return new DeliveryDto.Response(this.deliveryService.findById(id));
    }

    @PostMapping(value = "/delivery/${id}/logs")
    @ResponseStatus(value = HttpStatus.OK)
    public DeliveryDto.Response updateDelivery(
        @PathVariable final Long id, @RequestBody DeliveryDto.UpdateRequest dto
    ) {
        return new DeliveryDto.Response(this.deliveryService.updateDelivery(id, dto));
    }
}
