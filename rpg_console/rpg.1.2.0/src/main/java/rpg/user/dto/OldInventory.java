package rpg.user.dto;

import rpg.item.dto.Clothes;
import rpg.item.dto.Gift;
import rpg.item.dto.Item;
import rpg.item.store.ItemStore;
import rpg.util.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Deprecated
public class OldInventory {

    private final ItemStore itemStore;

    public OldInventory(ItemStore itemStore){
        this.itemStore = itemStore;
    }

    public <T extends Item> boolean addItem(T item) {

        System.out.println("addItem Generic method call");

        if (item instanceof Clothes) {
            return addItem((Clothes) item);
        }
        if (item instanceof Gift) {
            return addItem((Gift) item);
        }

        return false;
    }

    public boolean addItem(Clothes clothes) {
        List<Clothes> clothesList = itemStore.get(new TypeReference<List<Clothes>>() {});

        if (clothesList == null) {
            clothesList = new ArrayList<>();
            clothesList.add(clothes);

            return itemStore.save(clothesList, new TypeReference<List<Clothes>>() {});
        }

        return clothesList.add(clothes);

    }

    public boolean addItem(Gift gift) {

        List<Gift> giftList = itemStore.get(new TypeReference<List<Gift>>() {});

        if (giftList == null) {
            giftList = new ArrayList<>();
            giftList.add(gift);

            return itemStore.save(giftList, new TypeReference<List<Gift>>() {});
        }

        return giftList.add(gift);
    }

    public <T extends Item> boolean deleteItem(T item) {
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
