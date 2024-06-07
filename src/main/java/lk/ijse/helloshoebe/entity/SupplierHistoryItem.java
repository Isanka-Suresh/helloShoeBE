package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lk.ijse.helloshoebe.entity.key.SupplyItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(SupplyItemId.class)
@Entity
@Table(name = "supplier_history_item")
public class SupplierHistoryItem {
    @ManyToOne
    @Id
    private Item item;
    private int suppliedQty;
    @Temporal(TemporalType.DATE)
    private Date suppliedDate;

    @ManyToOne
    @Id
    private SupplierHistory supplierHistory;

    @Id
    @Enumerated(EnumType.STRING)
    private Colour colour;

    @Id
    @Enumerated(EnumType.STRING)
    private Size size;
}
