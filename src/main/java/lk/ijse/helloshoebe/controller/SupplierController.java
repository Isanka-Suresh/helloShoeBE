package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.CustomerDTO;
import lk.ijse.helloshoebe.dto.SupplierDTO;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/supplier")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    //Checking the Supplier Controller
    @GetMapping("/health")
    public String SupplierHealthCheck() {
        return "Supplier Working";

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers(){
        log.info("Selecting All Suppliers");
        try {
            List<SupplierDTO>supplierDTOS = supplierService.getAllSupplier();
            log.debug("Selected {} Suppliers Successfully",supplierDTOS.size());
            return ResponseEntity.status(HttpStatus.OK).body(supplierDTOS);
        }catch (NotFoundException e){
            log.error("Failed to Find Suppliers -> {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable("id")String supCode){
        log.info("Looking for Supplier {}",supCode);
        try {
            SupplierDTO supplierDTO = supplierService.getSelectedSupplier(supCode);
            log.debug("Found Supplier {}",supplierDTO.getSupplierCode());
            return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
        }catch (NotFoundException e){
            log.error("Supplier {} does not Exist",supCode);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDTO> saveSupplier(@RequestBody SupplierDTO supplierDTO){
        log.info("Adding new Supplier -> {}",supplierDTO);
        try {
            SupplierDTO savedSupplier = supplierService.saveSupplier(supplierDTO);
            log.debug("Supplier Added Successfully -> {}",savedSupplier);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSupplier);
        }catch (DuplicateException e){
            log.error("Failed to Add Supplier {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable("id") String supplierCode){
        log.info("Update Supplier {}",supplierCode);
        supplierDTO.setSupplierCode(supplierCode);
        try {
            SupplierDTO updatedSupplier = supplierService.updateSupplier(supplierDTO);
            log.debug("Supplier Updated Successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedSupplier);
        }catch (NotFoundException|DuplicateException e){
            log.error("Failed to Update Supplier {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable("id")String supCode){
        log.info("Deleting Supplier -> {}",supCode);
        try {
            supplierService.deleteSupplier(supCode);
            log.debug("Supplier {} Deleted Successfully",supCode);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch (NotFoundException e){
            log.error("Failed to Delete Supplier {}",e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
