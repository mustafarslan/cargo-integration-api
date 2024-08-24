package com.delivery.integration.service.tyexpress;

import com.delivery.integration.exception.DeliveryException;
import com.delivery.integration.model.PostResponse;
import com.delivery.integration.model.addressresolved.AddressResolveRequest;
import com.delivery.integration.model.addressresolved.AddressResolvedResponse;
import com.delivery.integration.model.common.BaseDeliveryService;
import com.delivery.integration.model.fastdelivery.FastDeliveryRequest;
import com.delivery.integration.model.fastdelivery.FastDeliveryResponse;
import com.delivery.integration.model.packagecreate.CreatePackageRequest;
import com.delivery.integration.model.packagecreate.CreatePackageResponse;

import com.delivery.integration.model.refund.RefundRequest;
import com.delivery.integration.model.refund.RefundResponse;
import com.delivery.integration.service.DeliveryService;

import com.delivery.integration.service.TYExpressDeliveryServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TYExpressDeliveryService  extends BaseDeliveryService implements DeliveryService {

    @Autowired
    private TYExpressDeliveryServiceManager manager;

    @Autowired
    private RestTemplate rt;

    @Override
    public Mono<CreatePackageResponse> createPackage(CreatePackageRequest request) throws DeliveryException {
        if(!validPackageRequest(request)){
            throw new DeliveryException("Invalid request");
        }

        try {
            return manager.createPackage(request);

        } catch (Exception e) {
            throw new DeliveryException(String.format("Error occurred when creating package, PackageId:%s. Message: %s", request.getId(), e.getMessage()), e);
        }
    }

    protected boolean validPackageRequest(CreatePackageRequest request) {
        return request.getId().length() > 5 && request.getId().length() < 10;
    }

    @Override
    public Mono<RefundResponse> refund(RefundRequest request) throws DeliveryException {
       return null;
    }

    @Override
    public Mono<FastDeliveryResponse> fastDelivery(FastDeliveryRequest request) throws DeliveryException {
        return null;
    }

    @Override
    public Mono<AddressResolvedResponse> addressResolve(AddressResolveRequest request) throws DeliveryException {
        return null;
    }

}