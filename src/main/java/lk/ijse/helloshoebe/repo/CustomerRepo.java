package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
