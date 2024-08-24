package com.delivery.integration.service;

import com.delivery.integration.exception.DeliveryException;
import com.delivery.integration.model.addressresolved.AddressResolveRequest;
import com.delivery.integration.model.addressresolved.AddressResolvedResponse;
import com.delivery.integration.model.fastdelivery.FastDeliveryRequest;
import com.delivery.integration.model.fastdelivery.FastDeliveryResponse;
import com.delivery.integration.model.packagecreate.CreatePackageResponse;
import com.delivery.integration.model.packagecreate.CreatePackageRequest;
import com.delivery.integration.model.refund.RefundRequest;
import com.delivery.integration.model.refund.RefundResponse;
import reactor.core.publisher.Mono;

public interface DeliveryService {

    Mono<CreatePackageResponse> createPackage(CreatePackageRequest request) throws DeliveryException;

    Mono<RefundResponse> refund(RefundRequest request) throws DeliveryException;

    Mono<FastDeliveryResponse> fastDelivery(FastDeliveryRequest request) throws DeliveryException;

    Mono<AddressResolvedResponse> addressResolve(AddressResolveRequest request) throws DeliveryException;


}
