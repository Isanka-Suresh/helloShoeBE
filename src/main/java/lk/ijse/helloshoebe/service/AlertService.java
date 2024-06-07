package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.AlertDTO;

import java.util.List;

public interface AlertService {
    AlertDTO saveAlert(AlertDTO alertDTO);
    void deleteAlert(String alertId);
    AlertDTO getSelectedAlert(String alertId);
    List<AlertDTO> getAllAlerts();
    AlertDTO updateAlert(AlertDTO alertDTO);
}
