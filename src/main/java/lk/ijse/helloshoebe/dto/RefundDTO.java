package lk.ijse.helloshoebe.dto;

import jakarta.persistence.OneToOne;
import lk.ijse.helloshoebe.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefundDTO {
    private String refundId;
    private Date refundDate;
    private String description;
}
