package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.entity.Customer;
import lk.ijse.helloshoebe.exception.InvalidDataException;
import lk.ijse.helloshoebe.repo.CustomerRepo;
import lk.ijse.helloshoebe.service.CustomerService;
import lk.ijse.helloshoebe.util.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(IdGenerator.generateId());
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepo.deleteById(customerId);
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return modelMapper.map(customerRepo.getReferenceById(customerId), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(), List.class);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepo.findById(customerDTO.getCustomerId()).orElseThrow(()->new InvalidDataException("Customer Not Found"));
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setGender(customerDTO.getGender());
        customer.setJoinedDate(customerDTO.getJoinedDate());
        customer.setLevel(customerDTO.getLevel());
        customer.setTotalPoints(customerDTO.getTotalPoints());
        customer.setDob(customerDTO.getDob());
        customer.setContactNumber(customerDTO.getContactNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setBuildingNumberOrName(customerDTO.getBuildingNumberOrName());
        customer.setAddressLane(customer.getAddressLane());
        customer.setAddressCity(customerDTO.getAddressCity());
        customer.setAddressState(customerDTO.getAddressState());
        customer.setPostalCode(customerDTO.getPostalCode());

        return modelMapper.map(customerRepo.save(customer), CustomerDTO.class);
    }
}
