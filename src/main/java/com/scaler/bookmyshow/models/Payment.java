package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentStatus;
import com.scaler.bookmyshow.enums.ProviderMethodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Payment extends BaseModel {

    private double amount;
    private String reference;

    @Enumerated
    private ProviderMethodType providertype;

    @Enumerated
    private PaymentStatus status;



}