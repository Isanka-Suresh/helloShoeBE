package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Gender;
import lk.ijse.helloshoebe.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private String employeeId;
    private String employeeName;
    private String contactNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePicture;
    private String employeeStatus;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Role accessRole;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private String attachedBranch;
    private String buildingNumberOrName;
    private String addressLane;
    private String addressCity;
    private String addressState;
    private String postalCode;
    private String emergencyContactNumber;
    private String emergencyContactName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sales> salesList;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Refund> refundList;
}
