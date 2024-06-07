package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    private String orderId;
    private int itemQty;
    private int addedPoints;
    private int totalPoints;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SalesItems> saleItems;
}
