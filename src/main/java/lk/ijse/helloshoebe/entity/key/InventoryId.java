package lk.ijse.helloshoebe.entity.key;

import lk.ijse.helloshoebe.entity.Item;
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
public class InventoryId implements Serializable {
    private Size size;
    private Colour colour;
    private Item item;
}
