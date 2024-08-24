package com.delivery.integration.service;

import com.delivery.integration.model.addressresolved.AddressResolvedResponse;
import com.delivery.integration.model.common.BaseRequest;
import com.delivery.integration.model.fastdelivery.FastDeliveryResponse;
import com.delivery.integration.model.packagecreate.CreatePackageResponse;
import com.delivery.integration.model.refund.RefundResponse;
import com.delivery.integration.service.tyexpress.TYExpressCargoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TYExpressDeliveryServiceManager {

    @Autowired
    private TYExpressCargoClient tyExpressCargoClient;

    public Mono<CreatePackageResponse> createPackage(BaseRequest request) {
        return tyExpressCargoClient.post("api/v1/create", request, CreatePackageResponse.class);
    }

    public Mono<RefundResponse> refund(BaseRequest request, String cargoType) {
        return tyExpressCargoClient.post("api/v1/refund", request, RefundResponse.class);
    }

    public Mono<FastDeliveryResponse> fastDelivery(BaseRequest request, String cargoType) {
        return tyExpressCargoClient.post("api/v1/fastDelivery", request, FastDeliveryResponse.class);
    }

    public Mono<AddressResolvedResponse> addressResolve(BaseRequest request, String cargoType) {
        return tyExpressCargoClient.post("api/v1/addressResolve", request, AddressResolvedResponse.class);
    }
}
