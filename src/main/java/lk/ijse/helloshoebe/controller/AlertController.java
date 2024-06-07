package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.AlertDTO;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.service.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/alert")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class AlertController {
    @Autowired
    private AlertService alertService;

    //Checking the Alert Controller
    @GetMapping("/health")
    public String alertHealthCheck() {
        return "Alert Working";

    }

    //Get All Alert
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlertDTO>> getAllAlert(){
        log.info("Selecting All Alert");
        try {
            List<AlertDTO> alertDTOS = alertService.getAllAlerts();
            log.debug("Selected {} Alert Successfully", alertDTOS.size());
            return ResponseEntity.status(HttpStatus.OK).body(alertDTOS);
        } catch (NotFoundException e) {
            log.error("Failed to find Alert -> {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //Get Selected Alert
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{alertId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlertDTO> getAlert(@PathVariable("alertId") String alertId){
        log.info("looking for Alert {}", alertId);
        System.out.println(alertId);
        try {
            AlertDTO alertDTO = this.alertService.getSelectedAlert(alertId);
            log.debug("Found Alert {}", alertDTO.getAlertId());
            return ResponseEntity.status(HttpStatus.OK).body(alertDTO);
        } catch (NotFoundException e) {
            log.error("Alert {} don't Exist", alertId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //Save Alert
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlertDTO> saveAlert(@RequestBody AlertDTO alertDTO){
        log.info("Adding new Alert -> {}", alertDTO);
        try {
            AlertDTO alert = alertService.saveAlert(alertDTO);
            log.debug("Alert Added Successfully -> {}", alert);
            return ResponseEntity.status(HttpStatus.CREATED).body(alert);
        } catch (DuplicateException e) {
            log.error("Failed to Add Alert {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //Update Alert
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlertDTO> updateAlert(@RequestBody AlertDTO alertDTO,@PathVariable("id") String alertId){
        log.info("Updating Alert {}", alertId);
        alertDTO.setAlertId(alertId);
        try {
            AlertDTO savedAlert = alertService.updateAlert(alertDTO);
            log.debug("Alert Updated Successfully -> {}", savedAlert);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAlert);
        } catch (NotFoundException | DuplicateException e) {
            log.error("Failed to Update Alert {}", e.getMessage(), e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    //Delete Alert
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteAlert(@PathVariable("id") String alertId){
        log.info("Deleting Alert -> {}", alertId);
        try {
            alertService.deleteAlert(alertId);
            log.debug("Alert {} Deleted Successfully", alertId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NotFoundException e) {
            log.error("Failed to Delete Alert {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
