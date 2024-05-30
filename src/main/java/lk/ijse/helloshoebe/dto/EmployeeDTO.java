package lk.ijse.helloshoebe.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.helloshoebe.entity.enums.Gender;
import lk.ijse.helloshoebe.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String employeeId;
    private String employeeName;
    private String contactNumber;
    private Gender gender;
    private String email;
    private String password;
    private String profilePicture;
    private String employeeStatus;
    private String designation;
    private Role accessRole;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinedDate;

    private String attachedBranch;
    private String buildingNumberOrName;
    private String addressLane;
    private String addressCity;
    private String addressState;
    private String postalCode;
    private String emergencyContactNumber;
    private String emergencyContactName;
}
