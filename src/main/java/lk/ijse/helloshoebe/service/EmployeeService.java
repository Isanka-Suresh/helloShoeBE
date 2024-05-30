package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(String employeeId);
    EmployeeDTO getSelectedEmployee(String employeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
}
