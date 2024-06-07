package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepo extends JpaRepository<Alert,String> {
}
