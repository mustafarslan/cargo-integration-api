package com.delivery.integration.service;

import com.delivery.integration.model.common.BaseRequest;
import com.delivery.integration.model.common.BaseResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService <T extends BaseRequest, R extends BaseResponse> {
    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public void setBaseUrl(String baseUrl) {
        this.webClient.get().uri(baseUrl);
    }

    public Mono<R> post(String uri, T request , Class<R> responseClass) {
        return this.webClient.post().uri(uri).body(BodyInserters.fromValue(request)).retrieve().bodyToMono(responseClass);
    }
}
