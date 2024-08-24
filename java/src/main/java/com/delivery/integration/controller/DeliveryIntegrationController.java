package com.delivery.integration.controller;

import com.delivery.integration.exception.DeliveryException;
import com.delivery.integration.model.addressresolved.AddressResolveRequest;
import com.delivery.integration.model.addressresolved.AddressResolvedResponse;
import com.delivery.integration.model.fastdelivery.FastDeliveryRequest;
import com.delivery.integration.model.fastdelivery.FastDeliveryResponse;
import com.delivery.integration.model.packagecreate.CreatePackageRequest;
import com.delivery.integration.model.packagecreate.CreatePackageResponse;
import com.delivery.integration.model.refund.RefundRequest;
import com.delivery.integration.model.refund.RefundResponse;
import com.delivery.integration.service.DeliveryServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/delivery-integration")
public class DeliveryIntegrationController {

    @Autowired
    private DeliveryServiceManager deliveryServiceManager;


    @PostMapping("/createDelivery")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<CreatePackageResponse> createPackage(@RequestBody CreatePackageRequest request, @RequestParam String cargoType) throws DeliveryException {
        return deliveryServiceManager.createPackage(request, cargoType);
    }

    @PutMapping("/refund")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<RefundResponse> refund(@RequestBody RefundRequest request, @RequestParam String cargoType) throws DeliveryException {
        return deliveryServiceManager.refund(request, cargoType);
    }

    @PostMapping("/fastDelivery")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<FastDeliveryResponse> fastDeliveryWithAras(@RequestBody FastDeliveryRequest request, @RequestParam String cargoType) throws DeliveryException {
        return deliveryServiceManager.fastDelivery(request, cargoType);
    }

    @PatchMapping("/addressResolve")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<AddressResolvedResponse> addressResolveWithPTT(@RequestBody AddressResolveRequest request, @RequestParam String cargoType) throws DeliveryException {
        return deliveryServiceManager.addressResolve(request, cargoType);
    }

}
