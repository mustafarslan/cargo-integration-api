package com.delivery.integration.service.tyexpress;

import com.delivery.integration.model.Constants;
import com.delivery.integration.model.common.BaseCargoClient;
import com.delivery.integration.model.common.BaseRequest;
import com.delivery.integration.model.common.BaseResponse;
import com.delivery.integration.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class TYExpressCargoClient implements BaseCargoClient {

    @Autowired
    private WebClientService webClientService;

    @PostConstruct
    void init() {
        webClientService.setBaseUrl(Constants.TY_EXPRESS_BASE_URL);
    }

    public <T extends BaseRequest, R extends BaseResponse> Mono<R> post(String uri, T request , Class<R> responseClass) {
        return webClientService.post(uri, request, responseClass);
    }
}
