package com.delivery.integration.model;

public class PostResponse<T> {
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
