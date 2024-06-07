package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.SupplierHistoryDTO;

import java.util.List;

public interface SupplierHistoryItemService {
    SupplierHistoryDTO saveSupplierHistoryItem(SupplierHistoryDTO supplierHistoryDTO);
    void deleteSupplierHistoryItem(String supplierHistoryId);
    SupplierHistoryDTO getSelectedSupplierHistoryItem(String supplierHistoryId);
    List<SupplierHistoryDTO> getAllSupplierHistoryItems();
    void updateSupplierHistoryItems(String supplierHistoryId,SupplierHistoryDTO supplierHistoryDTO);
}
