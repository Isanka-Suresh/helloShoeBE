package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "supplier-history")
public class SupplierHistory {
    @Id
    private String supplierHistoryId;
    @Temporal(TemporalType.DATE)
    private Date suppliedDate;
    private int totalQty;
    private double totalValue;

    @OneToMany(mappedBy = "supplierHistory", cascade = CascadeType.ALL)
    private List<SupplierHistoryItem> supplierHistoryItems;
}
