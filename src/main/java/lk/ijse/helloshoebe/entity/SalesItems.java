package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sales_items")
public class SalesItems {
    @Id
    private String salesItemId;

    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    private int qty;

    @OneToOne
    private Refund refund;
    @ManyToOne
    private Sales sales;
    @ManyToOne
    private Item item;
}
