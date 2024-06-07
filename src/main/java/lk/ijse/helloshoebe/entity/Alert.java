package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "alert")
public class Alert {
    @Id
    private String alertId;
    @Temporal(TemporalType.DATE)
    private Date alertDate;
    @Temporal(TemporalType.TIME)
    private Time alertTime;
    private String message;
}
