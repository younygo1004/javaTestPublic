package rpg.item.store;

import rpg.item.dto.Item;
import rpg.util.TypeReference;

import java.lang.reflect.Type;
import java.util.*;

/**
 * 해당 Class는 원래 ItemList를 저장하기 위해 정의하였다.
 * 그러나 현재는 user.store 패키지의 InventoryStore가 더 Type-Safety 하므로,
 * 해당 클래스보다는 InventoryStore의 사용을 고려할 수 있다.
 * 추후 InventoryStore Class 재정의 혹은 새로운 통합 Store Class를 만들어 사용을 고려하자.
 */
@Deprecated
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
