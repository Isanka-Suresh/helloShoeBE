package lk.ijse.helloshoebe.service;

import lk.ijse.helloshoebe.dto.ItemImageDTO;

import java.util.List;

public interface ItemImageService {
    ItemImageDTO saveItemImage(ItemImageDTO itemImageDTO);
    void deleteItemImage(String itemImageId);
    ItemImageDTO getSelectedItemImage(String itemImageId);
    List<ItemImageDTO> getAllItemImages();
    void updateItemImage(String itemImageId,ItemImageDTO itemImageDTO);
}
