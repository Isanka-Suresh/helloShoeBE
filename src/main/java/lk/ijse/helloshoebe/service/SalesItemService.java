package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.SalesItemDTO;

import java.util.List;

public interface SalesItemService {
    SalesItemDTO saveSalesItem(SalesItemDTO salesItemDTO);
    void deleteSalesItem(String salesItemId);
    SalesItemDTO getSelectedSalesItem(String salesItemId);
    List<SalesItemDTO> getAllSalesItems();
    void updateSalesItem(String salesItemId,SalesItemDTO salesItemDTO);
}
