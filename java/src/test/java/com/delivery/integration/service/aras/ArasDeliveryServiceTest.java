package com.delivery.integration.service.aras;

import com.delivery.integration.exception.DeliveryException;
import com.delivery.integration.model.PostResponse;
import com.delivery.integration.model.addressresolved.AddressResolveRequest;
import com.delivery.integration.model.addressresolved.AddressResolvedResponse;
import com.delivery.integration.model.fastdelivery.FastDeliveryRequest;
import com.delivery.integration.model.fastdelivery.FastDeliveryResponse;
import com.delivery.integration.model.packagecreate.CreatePackageRequest;
import com.delivery.integration.model.packagecreate.CreatePackageResponse;
import com.delivery.integration.model.refund.RefundRequest;
import com.delivery.integration.model.refund.RefundResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class ArasDeliveryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ArasDeliveryService arasDeliveryService;

    @Test
    void shouldCreatePackage() throws DeliveryException {
        //Arrange
        CreatePackageRequest request = Mockito.mock(CreatePackageRequest.class);

        CreatePackageResponse createPackageResponse = new CreatePackageResponse("61",
                true, "200", "OK", "packageCreated");

        PostResponse<CreatePackageResponse> postResponse = new PostResponse<>();
        postResponse.setResponse(createPackageResponse);

        ResponseEntity<PostResponse<CreatePackageResponse>> entityResp = new ResponseEntity<>(postResponse, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(entityResp);


        //Act
        CreatePackageResponse response = arasDeliveryService.createPackage(request);

        //Assert
        assertEquals(response.getResultCode(), "200");
        assertEquals(response.getSuccess(), true);
    }


    @Test
    void shouldThrowExceptionWhenPackageNotCreated() throws DeliveryException {
        //Arrange
        CreatePackageRequest request = Mockito.mock(CreatePackageRequest.class);

        CreatePackageResponse createPackageResponse = new CreatePackageResponse("61",
                false, "500", "Internal Server Error", "packageNotCreated");

        PostResponse<CreatePackageResponse> postResponse = new PostResponse<>();
        postResponse.setResponse(createPackageResponse);

        ResponseEntity<PostResponse<CreatePackageResponse>> entityResp = new ResponseEntity<>(postResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        Mockito.when(restTemplate.exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(entityResp);


        //Act
        CreatePackageResponse response = arasDeliveryService.createPackage(request);

        //Assert
        assertEquals(response.getResultCode(), "500");
        assertEquals(response.getSuccess(), false);
    }

    @Test
    void shouldRefund() throws DeliveryException {
        //Arrange
        RefundRequest request = Mockito.mock(RefundRequest.class);

        RefundResponse refundResponse = new RefundResponse(
                true, "200", "OK", "61", "refund");

        PostResponse<RefundResponse> postResponse = new PostResponse<>();
        postResponse.setResponse(refundResponse);

        ResponseEntity<PostResponse<RefundResponse>> entityResp = new ResponseEntity<>(postResponse, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(entityResp);


        //Act
        RefundResponse response = arasDeliveryService.refund(request);

        //Assert
        assertEquals(response.getResultCode(), "200");
        assertEquals(response.getSuccess(), true);
        assertEquals(response.getCargoReferenceNumber(), "61");
    }

    @Test
    void shouldFastDelivery() throws DeliveryException {
        //Arrange
        FastDeliveryRequest request = Mockito.mock(FastDeliveryRequest.class);

        FastDeliveryResponse fastDeliveryResponse = new FastDeliveryResponse("61",
                true, "200", "OK", "fastDelivery");

        PostResponse<FastDeliveryResponse> postResponse = new PostResponse<>();
        postResponse.setResponse(fastDeliveryResponse);

        ResponseEntity<PostResponse<FastDeliveryResponse>> entityResp = new ResponseEntity<>(postResponse, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(entityResp);


        //Act
        FastDeliveryResponse response = arasDeliveryService.fastDelivery(request);

        //Assert
        assertEquals(response.getResultCode(), "200");
        assertEquals(response.getSuccess(), true);
        assertEquals(response.getPackageId(), "61");
    }

    @Test
    void shouldAddressResolveReturnNull() throws DeliveryException {
        //Arrange
        AddressResolveRequest request = Mockito.mock(AddressResolveRequest.class);

        //Act
        AddressResolvedResponse response = arasDeliveryService.addressResolve(request);

        //Assert
        assertNull(response);
    }
}