package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.entity.Customer;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.InvalidDataException;
import lk.ijse.helloshoebe.exception.NotFoundException;
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
        try {
            customerDTO.setCustomerId(IdGenerator.generateId());
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
            return customerDTO;
        }catch (Exception e){
            throw new DuplicateException("Customer is already there");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        try{
            if (customerRepo.existsById(customerId)){
                customerRepo.deleteById(customerId);
            }
        }catch (Exception e){
            throw new NotFoundException("Customer does not Exist");
        }
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        try{
            if (customerRepo.existsById(customerId)){
                return modelMapper.map(customerRepo.findById(customerId), CustomerDTO.class);
            }
            throw new NotFoundException("Customer does not Exist");
        }catch (Exception e){
            throw new NotFoundException("Customer does not Exist");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        try {
            return modelMapper.map(customerRepo.findAll(), List.class);
        }catch (Exception e){
            throw new InvalidDataException("Relevant Data Can't be found");
        }
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())){
            try {
                Customer customer = modelMapper.map(customerDTO, Customer.class);
                return modelMapper.map(customerRepo.save(customer),CustomerDTO.class);
            }catch (Exception e){
                throw new DuplicateException("Customer Duplicate Data Entered");
            }
        }
        throw new NotFoundException("Customer Not Found");
    }
}
