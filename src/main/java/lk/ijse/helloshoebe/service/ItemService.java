package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO saveItem(ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemDTO getSelectedItem(String itemId);
    List<ItemDTO> getAllItems();
    ItemDTO updateItem(ItemDTO itemDTO);

    boolean updateItemStocks(ItemDTO itemDTO);
}
