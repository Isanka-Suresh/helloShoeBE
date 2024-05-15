package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.AlertDTO;
import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.entity.Customer;
import lk.ijse.helloshoebe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        System.out.println("Requested");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/getCustomer/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId")String custId){
        return ResponseEntity.ok(customerService.getSelectedCustomer(custId));
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("Save Customer Works");
        return ResponseEntity.ok(customerService.saveCustomer(customerDTO));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.updateCustomer(customerDTO));
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId")String custId){
        customerService.deleteCustomer(custId);
        return ResponseEntity.ok("Customer Deleted");
    }
}


