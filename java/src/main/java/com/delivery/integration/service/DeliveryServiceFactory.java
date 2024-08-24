package com.delivery.integration.service;

import com.delivery.integration.service.aras.ArasDeliveryService;
import com.delivery.integration.service.ptt.PTTDeliveryService;
import com.delivery.integration.service.tyexpress.TYExpressDeliveryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class DeliveryServiceFactory {
    @Autowired
    private ArasDeliveryService arasDeliveryService;

    @Autowired
    private PTTDeliveryService pttDeliveryService;

    @Autowired
    private TYExpressDeliveryService tyExpressDeliveryService;

    public DeliveryService getDeliveryService(String cargoType) {
        DeliveryService deliveryService = null;
        switch (cargoType.toLowerCase()){
            case "aras":
                deliveryService = arasDeliveryService;
            case "ptt":
                deliveryService = pttDeliveryService;
            case "tyexpress":
                deliveryService = tyExpressDeliveryService;
        }
        return deliveryService;
    }
}
