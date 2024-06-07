package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoebe.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    private String itemCode;
    private String itemDescription;

    @Enumerated(EnumType.STRING)
    private Category category;

    private double unitPurchasePrice;
    private double unitSellingPrice;
    private double profitPerUnit;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SalesItems> salesItemsList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier supplier;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Inventory> inventoryList;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SupplierHistoryItem> supplierHistoryItems;
}
