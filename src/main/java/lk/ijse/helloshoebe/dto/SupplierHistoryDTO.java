package lk.ijse.helloshoebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierHistoryDTO {
    private String supplierHistoryId;
    private Date suppliedDate;
    private Integer totalQty;
    private Double totalValue;
}
