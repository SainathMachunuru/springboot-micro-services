package com.msng.inventoryservice.repository;
import com.msng.inventoryservice.entity.InventoryItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/*import org.springframework.data.jpa.repository.JpaRepository;*/

//import java.util.Optional;
//
//public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
//
//    Optional<InventoryItem> findByProductCode(String productCode);
//}

@Repository
public class InventoryItemRepository {
    public InventoryItem findByProductCode(String productCode) {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setId(100);
        inventoryItem.setProductCode("p100");
        inventoryItem.setAvailableQuantity(10);

        return inventoryItem;

    }
    public List<InventoryItem>  findAll() {
        List<InventoryItem> inventoryItemList = new ArrayList<InventoryItem>();
        InventoryItem inventoryItem1 = new InventoryItem();
        inventoryItem1.setId(100);
        inventoryItem1.setProductCode("p100");
        inventoryItem1.setAvailableQuantity(10);

        InventoryItem inventoryItem2 = new InventoryItem();
        inventoryItem2.setId(101);
        inventoryItem2.setProductCode("p101");
        inventoryItem2.setAvailableQuantity(20);

        inventoryItemList.add(inventoryItem1);
        inventoryItemList.add(inventoryItem2);

        return inventoryItemList;

    }
}