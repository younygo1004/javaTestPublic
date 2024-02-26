package rpg.item.store;

import rpg.item.dto.Item;
import rpg.util.TypeReference;

import java.lang.reflect.Type;
import java.util.*;

public class ItemStore {

    private final Map<Type, Object> itemStore = new HashMap<>();

    public ItemStore() {

    }

    public <T extends List<? extends Item>> boolean save(T itemList, TypeReference<T> typeReference) {
        return itemStore.put(typeReference.getType(), itemList) != null;
    }

    public <T extends List<? extends Item>> T get(TypeReference<T> typeReference) {

        @SuppressWarnings("unchecked")
        T itemList = (T) itemStore.get(typeReference.getType());
        return itemList;
    }

    public List<Item> getAll() {
        List<Item> allItemList = new ArrayList<>();
        Collection<Object> itemValues = this.itemStore.values();

        itemValues.forEach((element) -> {

            @SuppressWarnings("unchecked")
            List<? extends Item> itemList = (List<? extends Item>) element;
            allItemList.addAll(itemList);
        });

//        for (Object obj : itemValues) {
//
//            @SuppressWarnings("unchecked")
//            List<? extends Item> itemList = (List<? extends Item>) obj;
//            allItemList.addAll(itemList);
//
//        }
        return allItemList;
    }


}
