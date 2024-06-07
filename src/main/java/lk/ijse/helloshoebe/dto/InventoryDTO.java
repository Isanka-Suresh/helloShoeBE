package lk.ijse.helloshoebe.dto;

import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lk.ijse.helloshoebe.entity.enums.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {
    private Size size;
    private Integer originalQty;
    private Integer currentQty;
    private StockStatus status;
    private Colour colour;
    private String itemImageId;
}
