package com.delivery.integration.model.refund;

import com.delivery.integration.model.common.BaseRequest;
import com.delivery.integration.model.common.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefundRequest extends BaseRequest {
    private String refundReferenceNumber;
    private BigDecimal amount;
    private Currency currency;
}
