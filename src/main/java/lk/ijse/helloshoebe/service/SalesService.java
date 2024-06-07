package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.SalesDTO;

import java.util.List;

public interface SalesService {
    SalesDTO saveSales(SalesDTO salesDTO);
    void deleteSales(String salesId);
    SalesDTO getSelectedSales(String salesId);
    List<SalesDTO> getAllSales();
    void updateSales(String salesId,SalesDTO salesDTO);
}
