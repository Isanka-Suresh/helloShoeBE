package lk.ijse.helloshoebe.repo;

import lk.ijse.helloshoebe.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {
}
