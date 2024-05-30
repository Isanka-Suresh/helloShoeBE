package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.dto.EmployeeDTO;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.service.EmployeeService;
import lk.ijse.helloshoebe.util.MultipartFileToStringEditor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/employee")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, "profilePicture", new MultipartFileToStringEditor());
    }

    @GetMapping("/health")
    public String employeeHealthCheck() {
        return "Employee Working";
    }

    //Get All Employees
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        log.info("Selecting All Employees");
        try {
            List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
            log.debug("Selected {} Employees Successfully",employeeDTOList.size());
            return ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
        }catch (NotFoundException e){
            log.error("Failed to find Employees -> {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("employeeId") String employeeId){
        log.info("looking for employee {}",employeeId);
        try{
            EmployeeDTO employeeDTO = employeeService.getSelectedEmployee(employeeId);
            log.debug("Found Employee {}",employeeDTO.getEmployeeId());
            return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
        }catch(NotFoundException e){
            log.error("Employee {} don't exist",employeeId,e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmployeeDTO> saveEmployee(@ModelAttribute EmployeeDTO employeeDTO){
        log.info("Adding a new Employee -> {}",employeeDTO);
        try{
            EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
            log.debug("Employee Added Successfully -> {}",savedEmployee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        }catch (DuplicateException e){
            log.error("Failed to Add Employee {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{employeeId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("employeeId")String employeeId, @ModelAttribute EmployeeDTO employeeDTO){
        log.info("Updating Employee {}",employeeId);
        employeeDTO.setEmployeeId(employeeId);
        try {
            EmployeeDTO savedEmployee = employeeService.updateEmployee(employeeDTO);
            log.debug("Employee Updated Successfully -> {}",savedEmployee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        }catch (NotFoundException|DuplicateException e){
            log.error("Failed to Update Customer {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")String employeeId){
        log.info("Deleting Employee {}",employeeId);
        try {
            employeeService.deleteEmployee(employeeId);
            log.debug("Employee {} Deleted Successfully",employeeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch (NotFoundException e){
            log.error("Failed to Delete Employee {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}