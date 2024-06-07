package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    void deleteInventory(String inventoryId);
    InventoryDTO getSelectedInventory(String inventoryId);
    List<InventoryDTO> getAllInventorys();
    void updateInventory(String inventoryId,InventoryDTO inventoryDTO);
}
