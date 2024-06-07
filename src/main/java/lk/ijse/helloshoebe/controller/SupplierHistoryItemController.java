package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/supplierHistoryItem")
@CrossOrigin
public class SupplierHistoryItemController {
    @GetMapping("/getSupplierHistoryItem")
    public String getSupplierHistoryItem(){
        return " get SupplierHistoryItem ";
    }

    @PostMapping("/saveSupplierHistoryItem")
    public String saveSupplierHistoryItem(){
        return "save SupplierHistoryItem";
    }

    @PutMapping("/updateSupplierHistoryItem")
    public String updateSupplierHistoryItem(){
        return "update SupplierHistoryItem";
    }

    @DeleteMapping("/deleteSupplierHistoryItem")
    public String deleteSupplierHistoryItem(){
        return "delete SupplierHistoryItem";
    }
}
