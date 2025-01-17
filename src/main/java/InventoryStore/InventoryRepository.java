package InventoryStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    @Query(value="Select * from inventory where id = ? 1", nativeQuery = true)
    public List<InventoryItem> search(@Param("keyword")  Long id);

}
