package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
}
