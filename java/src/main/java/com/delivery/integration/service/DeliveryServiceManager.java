package com.delivery.integration.service;

import com.delivery.integration.exception.DeliveryException;
import com.delivery.integration.model.common.BaseRequest;
import com.delivery.integration.model.common.BaseResponse;
import com.delivery.integration.model.packagecreate.CreatePackageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeliveryServiceManager<T extends BaseRequest, R extends BaseResponse> {
    @Autowired
    private DeliveryServiceFactory deliveryServiceFactory;

    public Mono<R> createPackage(T request, String cargoType) throws DeliveryException {
       return (Mono<R>) deliveryServiceFactory.getDeliveryService(cargoType).createPackage((CreatePackageRequest) request);
    }

    public Mono<R> refund(T request, String cargoType){
        return null;
    }

    public Mono<R> fastDelivery(T request, String cargoType){
        return null;
    }

    public Mono<R> addressResolve(T request, String cargoType){
        return null;
    }
}
