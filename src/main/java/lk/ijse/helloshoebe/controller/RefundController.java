package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/refund")
@CrossOrigin
public class RefundController {
    @GetMapping("/getRefund")
    public String getRefund(){
        return " get Refund ";
    }

    @PostMapping("/saveRefund")
    public String saveRefund(){
        return "save Refund";
    }

    @PutMapping("/updateRefund")
    public String updateRefund(){
        return "update Refund";
    }

    @DeleteMapping("/deleteRefund")
    public String deleteRefund(){
        return "delete Refund";
    }
}
