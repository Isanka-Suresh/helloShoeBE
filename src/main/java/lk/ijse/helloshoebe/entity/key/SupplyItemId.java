package lk.ijse.helloshoebe.entity.key;

import lk.ijse.helloshoebe.entity.Item;
import lk.ijse.helloshoebe.entity.SupplierHistory;
import lk.ijse.helloshoebe.entity.enums.Colour;
import lk.ijse.helloshoebe.entity.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SupplyItemId implements Serializable {
    private Item item;
    private SupplierHistory supplierHistory;
    private Colour colour;
    private Size size;
}
