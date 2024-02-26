package rpg.user.store;

import rpg.item.dto.Item;
import java.util.*;

public class InventoryStore {
    private final Map<Class<? extends Item>, Object> userItemStore;

    public InventoryStore() {
        userItemStore = new HashMap<>();
    }

    public <T extends Item> boolean save(Class<? extends Item> clazz, List<T> itemList) {

        return this.userItemStore.put(clazz, itemList) != null;

    }

    public <T extends Item> List<T> get(Class<T> clazz) {

        @SuppressWarnings("unchecked")
        List<T> itemList = (List<T>) this.userItemStore.get(clazz);

        return itemList;
    }

    public List<Item> getAll() {
        List<Item> allItemList = new ArrayList<>();
        Collection<Object> itemValues = this.userItemStore.values();

        itemValues.forEach((element) -> {

            @SuppressWarnings("unchecked")
            List<? extends Item> itemList = (List<? extends Item>) element;
            allItemList.addAll(itemList);
        });

        return allItemList;
    }

}
