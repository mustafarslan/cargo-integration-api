package com.delivery.integration.model.addressresolved;

import com.delivery.integration.model.common.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResolveRequest extends BaseRequest {
    private String id;
    private String name;
    private String address;
    private int desi;
    private double amount;
    private boolean isAddressResolvable = true;
}


