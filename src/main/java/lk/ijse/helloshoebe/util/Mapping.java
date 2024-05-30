package lk.ijse.helloshoebe.util;

import lk.ijse.helloshoebe.dto.*;
import lk.ijse.helloshoebe.entity.Inventory;
import lk.ijse.helloshoebe.entity.Item;
import lk.ijse.helloshoebe.entity.ItemImage;
import lk.ijse.helloshoebe.entity.Supplier;
import lk.ijse.helloshoebe.entity.enums.StockStatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    private List<ImgHolderDTO> imgHolderDTOList = new ArrayList<>();
    public Item toItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);
        createImageIds(itemDTO.getItemImageDTOList());

        Supplier supplier = new Supplier();
        supplier.setSupplierCode(itemDTO.getSupplierDTO().getSupplierCode());

        item.setSupplier(supplier);
        List<Inventory> inventoryList = new ArrayList<>();

        for (InventoryDTO inventoryDTO : itemDTO.getInventoryDTOList()) {
            Inventory inventory = new Inventory(
                    inventoryDTO.getSize(),
                    inventoryDTO.getOriginalQty(),
                    inventoryDTO.getCurrentQty(),
                    inventoryDTO.getStatus(),
                    inventoryDTO.getColour(),
                    item,
                    getItemImage(inventoryDTO.getItemImageId())
            );

            inventoryList.add(inventory);
        }

        item.setInventoryList(inventoryList);

        return item;

    }

    public ItemDTO toItemDTO(Item item) {
        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);

        itemDTO.setSupplierDTO(modelMapper.map(item.getSupplier(), SupplierDTO.class));

        List<ItemImageDTO> itemImageDTOList = new ArrayList<>();

        L1:
        for (Inventory tempInventory : item.getInventoryList()) {
            for (int i = 0; i < itemImageDTOList.size(); i++) {
                if (itemImageDTOList.get(i).getImageId().equals(tempInventory.getItemImage().getImageId())) {
                    continue L1;
                }
            }

            itemImageDTOList.add(
                    new ItemImageDTO(
                            tempInventory.getItemImage().getImageId(),
                            tempInventory.getItemImage().getImage()
                    )
            );

        }

        itemDTO.setItemImageDTOList(itemImageDTOList);
         return itemDTO;

    }

    public List<Item> toItemList(List<ItemDTO> itemDTOList) {
        return modelMapper.map(itemDTOList, new TypeToken<ArrayList<Item>>() {
        }.getType());

    }

    public List<ItemDTO> toItemDTOList(List<Item> itemList) {
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (Item item : itemList) {
            itemDTOList.add(
                    new ItemDTO(
                            item.getItemCode(),
                            item.getItemDescription(),
                            item.getCategory(),
                            item.getUnitPurchasePrice(),
                            item.getUnitSellingPrice(),
                            null,
                            null,
                            null

                    )
            );

        }

        return itemDTOList;

    }

    public List<Inventory> getStockList(ItemDTO itemDTO, Item item) {
        createImageIds(itemDTO.getItemImageDTOList());

        List<Inventory> inventoryList = new ArrayList<>();

        for (InventoryDTO inventoryDTO : itemDTO.getInventoryDTOList()) {
            Inventory inventory = new Inventory(
                    inventoryDTO.getSize(),
                    inventoryDTO.getOriginalQty(),
                    inventoryDTO.getCurrentQty(),
                    inventoryDTO.getStatus(),
                    inventoryDTO.getColour(),
                    item,
                    getItemImage(inventoryDTO.getItemImageId())
            );

            inventoryList.add(inventory);
        }

        return inventoryList;


    }

    public List<Inventory> toStockList(List<InventoryDTO> stockDTOList, Item item) {
        List<Inventory> stockList = new ArrayList<>();

        List<InventoryDTO> inventoryDTOList = new ArrayList<>();
        List<InventoryDTO> tempInventoryDTOListMaxQTY = new ArrayList<>();

        for (int i = 0; i < stockDTOList.size(); i++) {
            if (stockDTOList.get(i).getSize() == null) {
                inventoryDTOList = tempInventoryDTOListMaxQTY;
                tempInventoryDTOListMaxQTY = new ArrayList<>();
                System.out.println("Iter - " +i);
                continue;
            }

            tempInventoryDTOListMaxQTY.add(stockDTOList.get(i));
        }

        for (int i = 0; i < inventoryDTOList.size(); i++) {
            System.out.println(tempInventoryDTOListMaxQTY.get(i).getOriginalQty());

            Inventory inventory = new Inventory(
                    inventoryDTOList.get(i).getSize(),
                    inventoryDTOList.get(i).getOriginalQty(),
                    tempInventoryDTOListMaxQTY.get(i).getCurrentQty(),
                    inventoryDTOList.get(i).getStatus(),
                    inventoryDTOList.get(i).getColour(),
                    item,
                    getItemImage(item , inventoryDTOList.get(i).getItemImageId())

            );

            inventory.setStatus( statusCalc(inventory.getCurrentQty() , inventory.getOriginalQty() ));

            stockList.add(inventory);

        }

        return stockList;

    }

    private StockStatus statusCalc(int qty , int maxQty) {
        if (qty == 0) {
            return StockStatus.UNAVAILABLE;
        }

        if ((qty*2) > maxQty) {
            return StockStatus.AVAILABLE;
        } else {
            return StockStatus.LOW;
        }

    }

    private ItemImage getItemImage(Item item , String imageId) {
        for (Inventory inventory:item.getInventoryList()) {
            if (inventory.getItemImage().getImageId().equals(imageId)) {
                return inventory.getItemImage();
            }

        }

        return null;
    }

    private void createImageIds(List<ItemImageDTO> itemImageDTOList) {
        imgHolderDTOList = new ArrayList<>();

        for (int i = 0; i < itemImageDTOList.size(); i++) {
            String generatedId = IdGenerator.generateId();
            imgHolderDTOList.add(new ImgHolderDTO(itemImageDTOList.get(i).getImageId(), generatedId, itemImageDTOList.get(i).getImage()));

        }

        System.out.println(imgHolderDTOList.size());

    }

    private ItemImage getItemImage(String imgId) {
        for (ImgHolderDTO imgHolderDTO : imgHolderDTOList) {
            if (imgHolderDTO.getImgId().equals(imgId)) {
                ItemImage itemImage = new ItemImage();

                if (imgId.length() == 1) {
                    itemImage.setImageId(imgHolderDTO.getGeneratedImgId());

                } else {
                    itemImage.setImageId(imgId);

                }

                itemImage.setImageId(imgHolderDTO.getImg());

                return itemImage;

            }

        }

        return null;

    }
}
