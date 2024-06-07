package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.ItemDTO;
import lk.ijse.helloshoebe.entity.Inventory;
import lk.ijse.helloshoebe.entity.Item;
import lk.ijse.helloshoebe.entity.Supplier;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.repo.ItemImageRepo;
import lk.ijse.helloshoebe.repo.ItemRepo;
import lk.ijse.helloshoebe.repo.SupplierRepo;
import lk.ijse.helloshoebe.service.ItemService;
import lk.ijse.helloshoebe.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;
    private final SupplierRepo supplierRepo;
    private final ItemImageRepo itemImageRepo;
    private final Mapping mapping;
    private final ModelMapper modelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        try {
            Item item = mapping.toItem(itemDTO);
            Supplier supplier = supplierRepo.getReferenceById(item.getSupplier().getSupplierCode());

            item.setSupplier(supplier);

            for (Inventory inventory : item.getInventoryList()) {
                if (itemRepo.existsById(inventory.getItemImage().getImageId())){
                    continue;
                }
                itemImageRepo.save(inventory.getItemImage());
            }
            return mapping.toItemDTO(itemRepo.save(item));
        }catch (Exception e){
            throw new DuplicateException("Item Duplicate Details Entered");
        }
    }

    @Override
    public void deleteItem(String itemId) {
        if (itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
        }
        throw new NotFoundException("Item Not Found");
    }

    @Override
    public ItemDTO getSelectedItem(String itemId) {
        if (itemRepo.existsById(itemId)){
            return mapping.toItemDTO(itemRepo.getReferenceById(itemId));
        }
        throw new NotFoundException("Item Not Found");
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.toItemDTOList(itemRepo.findAll());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        try {
            if (itemRepo.existsById(itemDTO.getItemCode())){
                Item item = itemRepo.getReferenceById(itemDTO.getItemCode());
                item.setItemDescription(item.getItemDescription());
                item.setUnitPurchasePrice(itemDTO.getUnitPurchasePrice());
                item.setUnitSellingPrice(itemDTO.getUnitSellingPrice());

                List<Inventory>inventoryList = mapping.getStockList(itemDTO,item);

                for (Inventory inventory : inventoryList) {
                    item.getInventoryList().add(inventory);
                    itemImageRepo.save(inventory.getItemImage());
                }
                return mapping.toItemDTO(itemRepo.save(item));
            }
        }catch (Exception e) {
            throw new DuplicateException("Item Duplicate Data Entered");
        }
        throw new NotFoundException("Item Not Found");
    }

    @Transactional
    @Override
    public boolean updateItemStocks(ItemDTO itemDTO) {
        try {
            if (itemRepo.existsById(itemDTO.getItemCode())){
                Item item = itemRepo.getReferenceById(itemDTO.getItemCode());

                item.setInventoryList(mapping.toStockList(itemDTO.getInventoryDTOList(),item));

                itemRepo.save(item);
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new DuplicateException("Item Duplicate Data Entered");
        }
        throw new NotFoundException("Item Not Found");
    }
}
