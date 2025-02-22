package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entities.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

}
