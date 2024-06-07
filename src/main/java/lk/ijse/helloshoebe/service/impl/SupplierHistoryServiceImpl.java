package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.SupplierHistoryDTO;
import lk.ijse.helloshoebe.repo.SupplierHistoryRepo;
import lk.ijse.helloshoebe.service.SupplierHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierHistoryServiceImpl implements SupplierHistoryService {
    @Autowired
    private SupplierHistoryRepo supplierHistoryRepo;

    @Override
    public SupplierHistoryDTO saveSupplierHistory(SupplierHistoryDTO historyDTO) {
        return null;
    }

    @Override
    public void deleteSupplierHistory(String historyId) {

    }

    @Override
    public SupplierHistoryDTO getSelectedSupplierHistory(String historyId) {
        return null;
    }

    @Override
    public List<SupplierHistoryDTO> getAllSupplierHistory() {
        return null;
    }

    @Override
    public void updateSupplierHistory(String historyId, SupplierHistoryDTO historyDTO) {

    }
}
