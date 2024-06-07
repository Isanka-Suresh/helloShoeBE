package lk.ijse.helloshoebe.service.impl;

import lk.ijse.helloshoebe.dto.ItemImageDTO;
import lk.ijse.helloshoebe.repo.ItemImageRepo;
import lk.ijse.helloshoebe.service.ItemImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemImageServiceImpl implements ItemImageService {
    @Autowired
    private ItemImageRepo itemImageRepo;

    @Override
    public ItemImageDTO saveItemImage(ItemImageDTO itemImageDTO) {
        return null;
    }

    @Override
    public void deleteItemImage(String itemImageId) {

    }

    @Override
    public ItemImageDTO getSelectedItemImage(String itemImageId) {
        return null;
    }

    @Override
    public List<ItemImageDTO> getAllItemImages() {
        return null;
    }

    @Override
    public void updateItemImage(String itemImageId, ItemImageDTO itemImageDTO) {

    }
}
