package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,String> {
}
