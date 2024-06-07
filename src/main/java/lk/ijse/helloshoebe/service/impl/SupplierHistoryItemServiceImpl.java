package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.SupplierHistoryDTO;
import lk.ijse.helloshoebe.repo.SupplierHistoryItemRepo;
import lk.ijse.helloshoebe.service.SupplierHistoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierHistoryItemServiceImpl implements SupplierHistoryItemService {
    @Autowired
    private SupplierHistoryItemRepo supplierHistoryItemRepo;

    @Override
    public SupplierHistoryDTO saveSupplierHistoryItem(SupplierHistoryDTO supplierHistoryDTO) {
        return null;
    }

    @Override
    public void deleteSupplierHistoryItem(String supplierHistoryId) {

    }

    @Override
    public SupplierHistoryDTO getSelectedSupplierHistoryItem(String supplierHistoryId) {
        return null;
    }

    @Override
    public List<SupplierHistoryDTO> getAllSupplierHistoryItems() {
        return null;
    }

    @Override
    public void updateSupplierHistoryItems(String supplierHistoryId, SupplierHistoryDTO supplierHistoryDTO) {

    }
}
