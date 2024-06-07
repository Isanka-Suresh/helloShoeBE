package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/sales")
@CrossOrigin
public class SalesController {
    @GetMapping("/getSales")
    public String getSales(){
        return " get Sales ";
    }

    @PostMapping("/saveSales")
    public String saveSales(){
        return "save Sales";
    }

    @PutMapping("/updateSales")
    public String updateSales(){
        return "update Sales";
    }

    @DeleteMapping("/deleteSales")
    public String deleteSales(){
        return "delete Sales";
    }
}
