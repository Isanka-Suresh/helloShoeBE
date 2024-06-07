package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lk.ijse.helloshoebe.entity.enums.StockStatus;
import lk.ijse.helloshoebe.entity.key.InventoryId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(InventoryId.class)
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Enumerated(EnumType.STRING)
    private Size size;

    private int originalQty;
    private int currentQty;

    @Enumerated(EnumType.STRING)
    private StockStatus status;

    @Enumerated(EnumType.STRING)
    @Id
    private Colour colour;

    @ManyToOne
    @Id
    private Item item;

    @ManyToOne
    private ItemImage itemImage;
}
