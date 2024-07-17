package InventoryStore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity

@Table(name = "Inventory")

public class InventoryItem {

    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private String description;

    private int Price;


}
