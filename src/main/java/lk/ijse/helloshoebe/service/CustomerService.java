package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getSelectedCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
}
