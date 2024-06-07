package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/inventory")
@CrossOrigin
public class InventoryController {
    @GetMapping("/getInventory")
    public String getInventory(){
        return " get Inventory ";
    }

    @PostMapping("/saveInventory")
    public String saveInventory(){
        return "save Inventory";
    }

    @PutMapping("/updateInventory")
    public String updateInventory(){
        return "update Inventory";
    }

    @DeleteMapping("/deleteInventory")
    public String deleteInventory(){
        return "delete Inventory";
    }
}
