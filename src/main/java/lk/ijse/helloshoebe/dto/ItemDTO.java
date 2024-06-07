package lk.ijse.helloshoebe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lk.ijse.helloshoebe.entity.Supplier;
import lk.ijse.helloshoebe.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    @JsonProperty("itemCode")
    private String itemCode;
    private String itemDescription;
    private Category category;
    private Double unitSellingPrice;
     private Double unitPurchasePrice;

    private SupplierDTO supplierDTO;

    private List<InventoryDTO>inventoryDTOList;

    private List<ItemImageDTO> itemImageDTOList;
}
