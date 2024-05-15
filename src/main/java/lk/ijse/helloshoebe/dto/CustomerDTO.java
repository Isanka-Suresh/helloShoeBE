package lk.ijse.helloshoebe.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.helloshoebe.entity.enums.Gender;
import lk.ijse.helloshoebe.entity.enums.LoyaltyLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private Gender gender;
    private Date joinedDate;
    private LoyaltyLevel level;
    private Integer totalPoints;
    private Date dob;
    private String contactNumber;
    private String email;
    private String buildingNumberOrName;
    private String addressLane;
    private String addressCity;
    private String addressState;
    private String postalCode;
}
