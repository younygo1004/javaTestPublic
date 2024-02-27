package rpg.item.store;

import rpg.item.dto.Item;
import rpg.util.TypeReference;

import java.lang.reflect.Type;
import java.util.*;

/**
 * 해당 Class는 원래 List<Item> 객체를 저장하기 위해 정의하였다.
 * 그러나 해당 클래스는 List를 저장하거나 가져올 때, 반드시 Super Type Token을 전달해야 한다.
 * 현재 user.dto 패키지에 List<Item>을 담는 특화 Class InventoryStore가 있기 때문에
 * 해당 Class와 InventoryStore Class 중 용도에 맞는 것을 신중히 결정하는 것이 좋다.
 * 추후 InventoryStore Class 재정의 혹은 새로운 통합 Store Class를 만들어 사용을 고려하자.
 */
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

        return allItemList;
    }


}
