package com.delivery.integration.service.ptt;

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
class PTTDeliveryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PTTDeliveryService pttDeliveryService;

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
        CreatePackageResponse response = pttDeliveryService.createPackage(request);

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
        CreatePackageResponse response = pttDeliveryService.createPackage(request);

        //Assert
        assertEquals(response.getResultCode(), "500");
        assertEquals(response.getSuccess(), false);
    }

    @Test
    void shouldRefundReturnNull() throws DeliveryException {
        //Arrange
        RefundRequest request = Mockito.mock(RefundRequest.class);

        //Act
        RefundResponse response = pttDeliveryService.refund(request);

        //Assert
        assertNull(response);
    }

    @Test
    void shouldFastDeliveryReturnNull() throws DeliveryException {
        //Arrange
        FastDeliveryRequest request = Mockito.mock(FastDeliveryRequest.class);

        //Act
        FastDeliveryResponse response = pttDeliveryService.fastDelivery(request);

        //Assert
        assertNull(response);
    }

    @Test
    void shouldAddressResolve() throws DeliveryException {
        //Arrange
        AddressResolveRequest request = Mockito.mock(AddressResolveRequest.class);

        AddressResolvedResponse addressResolvedResponse = new AddressResolvedResponse("61",
                true, "200", "OK", "addressResolved");

        PostResponse<AddressResolvedResponse> postResponse = new PostResponse<>();
        postResponse.setResponse(addressResolvedResponse);

        ResponseEntity<PostResponse<AddressResolvedResponse>> entityResp = new ResponseEntity<>(postResponse, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(entityResp);


        //Act
        AddressResolvedResponse response = pttDeliveryService.addressResolve(request);

        //Assert
        assertEquals(response.getResultCode(), "200");
        assertEquals(response.getSuccess(), true);
        assertEquals(response.getPackageId(), "61");
    }
}