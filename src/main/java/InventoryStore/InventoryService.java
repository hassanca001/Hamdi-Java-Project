package InventoryStore;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repo1;


    public InventoryService(InventoryRepository repo1) {
        this.repo1 = repo1;
    }

    //insertion
    public void insertInventory(InventoryItem inventoryItem){
        repo1.save(inventoryItem);
    }

    //UPDATE
    public void updateInventory(InventoryItem inventoryItem){
        repo1.save(inventoryItem);
    }

    //Delete
    public void deleteInventory(Long id){
        repo1.deleteById(id);
    }

    //Getting Inventory From store using by id
    public InventoryItem getInventoryById(Long id){
        return repo1.findById(id).orElse(null);
    }

    //Getting all Inventory From store

    public List<InventoryItem> getAllInventory(Long keyword){
        if(keyword != null)
            return repo1.search(keyword);
        return repo1.findAll();

    }



}
