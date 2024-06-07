package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/saleItems")
@CrossOrigin
public class SaleItemsController {
    @GetMapping("/getSaleItems")
    public String getSaleItems(){
        return " get SaleItems ";
    }

    @PostMapping("/saveSaleItems")
    public String saveSaleItems(){
        return "save SaleItems";
    }

    @PutMapping("/updateSaleItems")
    public String updateSaleItems(){
        return "update SaleItems";
    }

    @DeleteMapping("/deleteSaleItems")
    public String deleteSaleItems(){
        return "delete SaleItems";
    }
}
