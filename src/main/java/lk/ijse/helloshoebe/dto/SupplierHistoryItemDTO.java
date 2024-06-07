package lk.ijse.helloshoebe.dto;

import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lk.ijse.helloshoebe.entity.key.SupplyItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierHistoryItemDTO {
    private SupplyItemId supplyItemId;
    private Integer suppliedQty;
    private Date suppliedDate;
    private Colour colour;
    private Size size;
}
