package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Gender;
import lk.ijse.helloshoebe.entity.enums.LoyaltyLevel;
import lk.ijse.helloshoebe.entity.enums.Gender;
import lk.ijse.helloshoebe.entity.enums.LoyaltyLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Enumerated(EnumType.STRING)
    private LoyaltyLevel level;
    private int totalPoints;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String contactNumber;
    @Column(unique = true)
    private String email;
    private String buildingNumberOrName;
    private String addressLane;
    private String addressCity;
    private String addressState;
    private String postalCode;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sales> salesList;
}
