package com.bank.customer.controller;

import com.bank.customer.dto.KycRequest;
import com.bank.customer.dto.CustomerProfileDTO;
import com.bank.customer.entity.Customer;
import com.bank.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    	log.info("Received request to add a customer details");
        return ResponseEntity.ok(service.saveCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);
        log.info("Received request to get customer details by Id");
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/{id}/kyc")
    public ResponseEntity<String> updateKycStatus(@PathVariable Long id, @RequestBody KycRequest request) {
        boolean updated = service.updateKycStatus(id, request.getAadhar(), request.getPan());
        log.info("Received request to update the kyc status");
        if (updated) {
            return ResponseEntity.ok("KYC updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("KYC validation failed.");
        }
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<CustomerProfileDTO> getCustomerProfile(@PathVariable Long id,
                                                                 @RequestParam String aadhar) {
    	log.info("Received request to get a customer profile");
        return ResponseEntity.ok(service.getProfile(id, aadhar));
    }
    
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
    	return ResponseEntity.ok(service.getAllCustomers());
    }
}
