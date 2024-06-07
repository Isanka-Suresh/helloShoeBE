package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.SalesItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesItemsRepo extends JpaRepository<SalesItems,String> {
}
