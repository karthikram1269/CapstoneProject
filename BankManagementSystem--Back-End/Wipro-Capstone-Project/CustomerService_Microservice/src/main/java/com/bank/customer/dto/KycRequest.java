package com.bank.customer.dto;

import lombok.Data;

@Data
public class KycRequest {
    private String aadhar;
    private String pan;
}
