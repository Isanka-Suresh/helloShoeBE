package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.EmployeeDTO;
import lk.ijse.helloshoebe.entity.Employee;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.InvalidDataException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.repo.EmployeeRepo;
import lk.ijse.helloshoebe.service.EmployeeService;
import lk.ijse.helloshoebe.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        try {
            employeeDTO.setEmployeeId(IdGenerator.generateId());
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return employeeDTO;
        }catch (Exception e){
            throw new DuplicateException("Employee is already there");
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        try {
            if (employeeRepo.existsById(employeeId)){
                employeeRepo.deleteById(employeeId);
            }
        }catch (Exception e){
            throw new NotFoundException("Supplier Does not Exist");
        }
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        try {
            if (employeeRepo.existsById(employeeId)){
                return modelMapper.map(employeeRepo.getReferenceById(employeeId),EmployeeDTO.class);
            }
            throw new NotFoundException("Employee does not Exist");
        }catch (Exception e){
            throw new NotFoundException("Employee does not Exist");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        try {
            return modelMapper.map(employeeRepo.findAll(), List.class);
        }catch (Exception e){
            throw new InvalidDataException("Relevant Data Can't be found");
        }
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmployeeId())){
            try {
                Employee employee = modelMapper.map(employeeDTO, Employee.class);
                return modelMapper.map(employeeRepo.save(employee), EmployeeDTO.class);
            }catch (Exception e){
                throw new DuplicateException("Employee Duplicate Data Entered");
            }
        }
        throw new NotFoundException("Customer Not Found");
    }
}
