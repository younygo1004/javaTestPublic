package rpg.shop;

import rpg.item.dto.Item;

/**
 * 해당 Class 대신 ItemShop Class 사용!
 */
@Deprecated
public abstract class ItemShopOld {

    protected Item[] itemList;

    protected ItemShopOld() {
    }
    public ItemShopOld(Item[] itemList) {
        this.itemList = itemList;
    }

    public abstract Item[] getItemList();

    public abstract Item sellItem(int index);



}
