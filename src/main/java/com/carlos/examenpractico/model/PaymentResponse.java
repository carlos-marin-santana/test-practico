package com.carlos.examenpractico.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentResponse extends BaseModel {
    private Double payment;

    @Builder
    public PaymentResponse(Double payment, Boolean success){
        super(success);
        this.payment = payment;
    }
}
