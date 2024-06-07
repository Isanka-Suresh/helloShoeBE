package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.InventoryDTO;
import lk.ijse.helloshoebe.repo.InventoryRepo;
import lk.ijse.helloshoebe.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public InventoryDTO saveInventory(InventoryDTO inventoryDTO) {
        return null;
    }

    @Override
    public void deleteInventory(String inventoryId) {

    }

    @Override
    public InventoryDTO getSelectedInventory(String inventoryId) {
        return null;
    }

    @Override
    public List<InventoryDTO> getAllInventorys() {
        return null;
    }

    @Override
    public void updateInventory(String inventoryId, InventoryDTO inventoryDTO) {

    }
}
