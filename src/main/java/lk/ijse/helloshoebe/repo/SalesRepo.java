package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepo extends JpaRepository<Sales,String> {
}
