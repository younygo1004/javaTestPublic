package rpg.user.dto;

import rpg.item.dto.Clothes;
import rpg.item.dto.Gift;
import rpg.item.dto.Item;
import rpg.item.store.ItemStore;
import rpg.util.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Inventory<T extends Item> {

    private final ItemStore itemStore;

    public Inventory(ItemStore itemStore){
        this.itemStore = itemStore;
    }

    public boolean addItem(T item) {
        List<T> itemList = itemStore.get(new TypeReference<List<T>>() {});

        if (itemList == null) {
            itemList = new ArrayList<>();
            itemList.add(item);
            return itemStore.save(itemList, new TypeReference<List<T>>() {});
        }

        return itemList.add(item);

    }

    public boolean deleteItem(T item) {
        List<T> itemList = itemStore.get(new TypeReference<List<T>>() {});

        return itemList != null && itemList.remove(item);
    }

    public List<Gift> getGiftItemList() {
        return itemStore.get(new TypeReference<List<Gift>>() {});
    }

    public List<Clothes> getClothesItemList() {
        return itemStore.get(new TypeReference<List<Clothes>>() {});
    }

    public List<Item> getAllItems() {
        return itemStore.getAll();
    }

    @Override
    public String toString() {
        List<Item> allItem = getAllItems();
        String[] itemNames = new String[allItem.size()];

        int size = allItem.size();
        for (int i = 0; i < size; i++) {
            itemNames[i] = allItem.get(i).getName();
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");

        for (String itemName : itemNames) {
            stringJoiner.add(itemName);
        }

        return stringJoiner.toString();
    }
}
