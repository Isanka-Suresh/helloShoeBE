package lk.ijse.helloshoebe.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.helloshoebe.entity.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDTO {
    private String orderId;
    private Integer addedPoints;
    private PaymentMethod paymentMethod;
    private Double totalPrice;
}
