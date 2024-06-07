package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/supplierHistory")
@CrossOrigin
public class SupplierHistoryController {
    @GetMapping("/getSupplierHistory")
    public String getSupplierHistory(){
        return " get SupplierHistory ";
    }

    @PostMapping("/saveSupplierHistory")
    public String saveSupplierHistory(){
        return "save SupplierHistory";
    }

    @PutMapping("/updateSupplierHistory")
    public String updateSupplierHistory(){
        return "update SupplierHistory";
    }

    @DeleteMapping("/deleteSupplierHistory")
    public String deleteSupplierHistory(){
        return "delete SupplierHistory";
    }
}
