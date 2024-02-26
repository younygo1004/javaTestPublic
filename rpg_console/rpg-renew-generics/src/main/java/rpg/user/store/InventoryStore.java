package rpg.user.store;

import rpg.item.dto.Clothes;
import rpg.item.dto.Gift;
import rpg.item.dto.Item;
import rpg.user.dto.Inventory;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class InventoryStore {

    private final Inventory<Clothes> clothesInventory;
    private final Inventory<Gift> giftInventory;

    private final Map<Class<? extends Item>, Object> userItemStore;

    public InventoryStore() {
        clothesInventory = new Inventory<>();
        giftInventory = new Inventory<>();
        userItemStore = new HashMap<>();
        userItemStore.put(Clothes.class, clothesInventory);

    }



}
