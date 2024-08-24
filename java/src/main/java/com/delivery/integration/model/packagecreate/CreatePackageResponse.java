package com.delivery.integration.model.packagecreate;

import com.delivery.integration.model.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePackageResponse extends BaseResponse {
    private String packageId;
    private String resultCode;
    private String resultMessage;
    private String rawResponse;
    private Boolean isSuccess;
}
