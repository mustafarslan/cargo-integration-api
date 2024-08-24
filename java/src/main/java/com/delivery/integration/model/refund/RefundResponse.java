package com.delivery.integration.model.refund;

import com.delivery.integration.model.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundResponse extends BaseResponse {
    private Boolean isSuccess;
    private String resultCode;
    private String resultMessage;
    private String cargoReferenceNumber;
    private String rawResponse;
}
