package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.AlertDTO;
import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.entity.Customer;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //Checking the Customer Controller
    @GetMapping("/health")
    public String customerHealthCheck() {
        return "Customer Working";

    }

    //Get All Customers
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        log.info("Selecting All Customers");
        try {
            List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
            log.debug("Selected {} Customers Successfully", customerDTOList.size());
            return ResponseEntity.status(HttpStatus.OK).body(customerDTOList);
        } catch (NotFoundException e) {
            log.error("Failed to find Customers -> {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    //Get Selected Customer
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") String customerId) {
        log.info("looking for Customer {}", customerId);
        System.out.println(customerId);
        try {
            CustomerDTO customerDTO = customerService.getSelectedCustomer(customerId);
            log.debug("Found Customer {}", customerDTO.getCustomerId());
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        } catch (NotFoundException e) {
            log.error("Customer {} don't Exist", customerId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //Save Customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        log.info("Adding new Customer -> {}", customerDTO);
        try {
            CustomerDTO savedCustomer = customerService.saveCustomer(customerDTO);
            log.debug("Customer Added Successfully -> {}", savedCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
        } catch (DuplicateException e) {
            log.error("Failed to Add Customer {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //Update Customer
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String customerId) {
        log.info("Updating Customer {}", customerId);
        customerDTO.setCustomerId(customerId);
        try {
            CustomerDTO savedCustomer = customerService.updateCustomer(customerDTO);
            log.debug("Customer Updated Successfully -> {}", savedCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
        } catch (NotFoundException | DuplicateException e) {
            log.error("Failed to Update Customer {}", e.getMessage(), e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    //Delete Customer
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String customerId) {
        log.info("Deleting Customer -> {}", customerId);
        try {
            customerService.deleteCustomer(customerId);
            log.debug("Customer {} Deleted Successfully", customerId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NotFoundException e) {
            log.error("Failed to Delete Customer {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}