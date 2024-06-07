package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    List<SupplierDTO> getAllSupplier();
    SupplierDTO updateSupplier(SupplierDTO supplierDTO);
}
