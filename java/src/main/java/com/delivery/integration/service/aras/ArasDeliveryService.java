package com.delivery.integration.service.aras;

import com.delivery.integration.exception.DeliveryException;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
public class ArasDeliveryService extends BaseDeliveryService implements DeliveryService {

    @Autowired
    private RestTemplate rt;


    @Override
    public Mono<CreatePackageResponse> createPackage(CreatePackageRequest request) throws DeliveryException {
        return null;
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
