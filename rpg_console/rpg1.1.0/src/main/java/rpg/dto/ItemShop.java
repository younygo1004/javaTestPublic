package rpg.dto;

public abstract class ItemShop {

    protected Item[] itemList;

    protected ItemShop() {
    }
    public ItemShop(Item[] itemList) {
        this.itemList = itemList;
    }

    public abstract Item[] getItemList();

    public abstract Item sellItem(int index);



}
