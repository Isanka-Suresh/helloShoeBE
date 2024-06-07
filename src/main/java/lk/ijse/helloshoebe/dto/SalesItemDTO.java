package lk.ijse.helloshoebe.dto;

import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesItemDTO {
    private String saleItemId;
    private Integer qty;
    private Size size;
    private Colour colour;
    private Double unitPrice;
}
