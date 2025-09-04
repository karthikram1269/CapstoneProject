package com.bank.customer.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long contactId;
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private Integer age;
    private String gender;
    private String kyc;
}
