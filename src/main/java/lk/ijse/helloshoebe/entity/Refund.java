package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "refund")
public class Refund {
    @Id
    private String refundId;
    @Temporal(TemporalType.DATE)
    private Date refundDate;
    private String description;
    private double value;
    private int qty;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @OneToOne
    private SalesItems salesItems;
}
