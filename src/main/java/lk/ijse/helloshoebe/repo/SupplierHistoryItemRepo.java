package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.SupplierHistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierHistoryItemRepo extends JpaRepository<SupplierHistoryItem,String> {
}
