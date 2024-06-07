package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.SupplierHistoryDTO;

import java.util.List;

public interface SupplierHistoryService {
    SupplierHistoryDTO saveSupplierHistory(SupplierHistoryDTO historyDTO);
    void deleteSupplierHistory(String historyId);
    SupplierHistoryDTO getSelectedSupplierHistory(String historyId);
    List<SupplierHistoryDTO> getAllSupplierHistory();
    void updateSupplierHistory(String historyId,SupplierHistoryDTO historyDTO);
}
