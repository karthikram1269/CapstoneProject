package com.bank.customer.service;

import com.bank.customer.dto.AccountResponse;
import com.bank.customer.dto.CustomerProfileDTO;
import com.bank.customer.dto.CustomerResponse;
import com.bank.customer.entity.Customer;
import com.bank.customer.exception.CustomerNotFoundException;
import com.bank.customer.repository.CustomerRepository;

import com.bank.customer.feign.AccountClient;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final AccountClient accountClient;

    public CustomerService(CustomerRepository repository, AccountClient accountClient) {
        this.repository = repository;
        this.accountClient = accountClient;
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id)
        		.orElseThrow(() -> new CustomerNotFoundException("Customer not found with the id :"+id));
    }

    public boolean updateKycStatus(Long id, String aadhar, String pan) {
        Optional<Customer> customerOpt = repository.findById(id);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            if (aadhar != null && pan != null) {
                customer.setKyc("true");
                repository.save(customer);
                return true;
            }
        }
        return false;
    }

    public CustomerProfileDTO getProfile(Long customerId, String aadhar) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        AccountResponse account = accountClient.getAccountByAadhar(aadhar);

        return new CustomerProfileDTO(toResponse(customer), account);
    }

    private CustomerResponse toResponse(Customer customer) {
    	
        CustomerResponse response = new CustomerResponse();
        response.setContactId(customer.getCustomerId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setMobileNumber(customer.getMobileNumber());
        response.setAddress(customer.getAddress());
        response.setAge(customer.getAge());
        response.setGender(customer.getGender());
        response.setKyc(customer.getKyc());
        
        return response; 
    }
    
    public List<Customer> getAllCustomers(){
    	return repository.findAll();
    }
    
}
