package lk.ijse.helloshoebe.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/itemImg")
@CrossOrigin
public class ItemImageController {
    @GetMapping("/getItemImage")
    public String getItemImage(){
        return " get ItemImage ";
    }

    @PostMapping("/saveItemImage")
    public String saveItemImage(){
        return "save ItemImage";
    }

    @PutMapping("/updateItemImage")
    public String updateItemImage(){
        return "update ItemImage";
    }

    @DeleteMapping("/deleteItemImage")
    public String deleteItemImage(){
        return "delete ItemImage";
    }
}
