package lk.ijse.helloshoebe.controller;

import lk.ijse.helloshoebe.dto.ItemDTO;
import lk.ijse.helloshoebe.exception.DuplicateException;
import lk.ijse.helloshoebe.exception.NotFoundException;
import lk.ijse.helloshoebe.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/item")
@CrossOrigin
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/health")
    public String itemHealthCheck(){
        return "Item working";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getAllItem(){
        log.info("Selecting All Items");
        try {
            List<ItemDTO>itemDTOList = itemService.getAllItems();
            log.debug("Selected {} Items",itemDTOList.size());
            return ResponseEntity.status(HttpStatus.OK).body(itemDTOList);
        }catch (NotFoundException e) {
            log.error("Failed to find Items -> {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getItem(@PathVariable("id")String itemCode){
        log.info("looking for Item {}",itemCode);
        try {
            ItemDTO itemDTO = itemService.getSelectedItem(itemCode);
            log.debug("Found Item {}",itemDTO.getItemCode());
            return ResponseEntity.status(HttpStatus.OK).body(itemDTO);
        }catch (NotFoundException e) {
            log.error("Item {} don't Exist", itemCode, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> saveItem(@RequestBody ItemDTO itemDTO){
        log.info("Adding new Item {}",itemDTO);
        try {
            ItemDTO savedItem = itemService.saveItem(itemDTO);
            log.debug("Saved Item Successfully -> {}",savedItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
        }catch (DuplicateException e){
            log.error("Failed to Add Item {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> updateItem(@PathVariable("id")String itemcode,@RequestBody ItemDTO itemDTO){
        log.info("Updating Item {}",itemcode);
        itemDTO.setItemCode(itemcode);
        try {
            ItemDTO updateItem = itemService.updateItem(itemDTO);
            log.debug("Updated Item Successfully -> {}",updateItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(updateItem);
        }catch (NotFoundException | DuplicateException e) {
            log.error("Failed to Update Item {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ItemDTO> deleteItem(@PathVariable("id") String itemCode) {
        log.info("Deleting Item -> {}",itemCode);
        try {
            itemService.deleteItem(itemCode);
            log.debug("Item {} Deleted Successfully", itemCode);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (NotFoundException e) {
            log.error("Failed to Delete Item {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/qty/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> updateItemStocks(@PathVariable("id") String itemCode , @RequestBody ItemDTO itemDTO) {
        itemDTO.setItemCode(itemCode);
        try {
            itemService.updateItemStocks(itemDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(itemDTO);
        } catch (NotFoundException | DuplicateException exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }
}
