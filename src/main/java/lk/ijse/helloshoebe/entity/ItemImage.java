package lk.ijse.helloshoebe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item-images")
public class ItemImage {
    @Id
    private String imageId;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    @OneToMany(mappedBy = "itemImage",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Inventory> inventoryList;
}
