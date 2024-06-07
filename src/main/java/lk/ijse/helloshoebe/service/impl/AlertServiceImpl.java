package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.AlertDTO;
import lk.ijse.helloshoebe.entity.Alert;
import lk.ijse.helloshoebe.exception.InvalidDataException;
import lk.ijse.helloshoebe.repo.AlertRepo;
import lk.ijse.helloshoebe.service.AlertService;
import lk.ijse.helloshoebe.util.IdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertRepo alertRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AlertDTO saveAlert(AlertDTO alertDTO) {
        alertDTO.setAlertId(IdGenerator.generateId());
        alertRepo.save(modelMapper.map(alertDTO, Alert.class));
        return alertDTO;
    }

    @Override
    public void deleteAlert(String alertId) {
        alertRepo.deleteById(alertId);
    }

    @Override
    public AlertDTO getSelectedAlert(String alertId) {
        return modelMapper.map(alertRepo.getReferenceById(alertId), AlertDTO.class);
    }

    @Override
    public List<AlertDTO> getAllAlerts() {
        return modelMapper.map(alertRepo.findAll(),List.class);
    }

    @Override
    public AlertDTO updateAlert( AlertDTO alertDTO) {
        Alert alert = alertRepo.findById(alertDTO.getAlertId()).orElseThrow(() -> new InvalidDataException("Alert not found with ID: " + alertDTO.getAlertId()));
        alert.setAlertDate(alertDTO.getAlertDate());
        alert.setAlertTime(alertDTO.getAlertTime());
        alert.setMessage(alertDTO.getMessage());

        return modelMapper.map(alertRepo.save(alert), AlertDTO.class);
    }
}
