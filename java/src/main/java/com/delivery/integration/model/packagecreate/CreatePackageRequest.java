package com.delivery.integration.model.packagecreate;


import com.delivery.integration.model.common.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePackageRequest extends BaseRequest {
    @NotNull(message="id can not be null")
    private String id;
    @Size(min=3, max=50, message = "Name's length must be between 3 - 50 characters")
    private String name;
    @Size(min=100, max=500, message = "Address length must be between 100 - 500 characters")
    private String address;
    @Min(value = 1, message="Desi should not be less than 1")
    @Max(value = 100, message="Desi should not be greater than 100")
    private int desi;
    @Positive
    private double amount;
}


