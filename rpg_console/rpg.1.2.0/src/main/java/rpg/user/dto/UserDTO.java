package rpg.user.dto;

import rpg.item.dto.Clothes;
import rpg.item.dto.Gift;
import rpg.item.dto.Item;
import rpg.item.store.ItemStore;
import rpg.user.store.InventoryStore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class UserDTO {

    private String name;
    private int charm;

    private final InventoryStore inventoryStore = new InventoryStore();

    private Item equippedItem;
    private int money = 10000000;

    public UserDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public <T extends Item> boolean obtainItem(T item) {

        @SuppressWarnings("unchecked")
        List<T> itemList = (List<T>) this.inventoryStore.get(item.getClass());

        if (itemList == null) {
            itemList = new ArrayList<>();
            itemList.add(item);
             return this.inventoryStore.save(item.getClass(), itemList);
        }

        return itemList.add(item);
    }

    public <T extends Item> boolean loseItem(T item) {

        @SuppressWarnings("unchecked")
        List<T> itemList = (List<T>) this.inventoryStore.get(item.getClass());

        // 아이템이 없으므로 아이템을 삭제할 수 없음
        if (itemList == null) {
            return false;
        }

        return itemList.remove(item);
    }

    public List<Clothes> getHaveClothesList() {
        return this.inventoryStore.get(Clothes.class);
    }

    public List<Gift> getHaveGiftList() {
        return this.inventoryStore.get(Gift.class);
    }

    public List<Item> getHaveAllItemList() {
        return this.inventoryStore.getAll();
    }

    public Item getEquippedItem() {
        return equippedItem;
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {

        if (money < 0)
            throw new InputMismatchException("돈은 음수값으로 설정할 수 없습니다.");

        this.money = money;
    }

    public void equipItem(Item item) {
        // 이미 장착중이던 아이템의 매력도를 빼야 한다.
        if (this.getEquippedItem() != null) {
            this.minusCharm(this.getEquippedItem().getCharm());
        }
        // 아이템 장착!
        this.setEquippedItem(item);
        // 아이템을 장착하면 그 아이템의 매력도만큼 나의 매력도가 올라간다.
        this.addCharm(item.getCharm());
    }

    public void addMoney(int money) {
        this.setMoney(this.getMoney() + money);
    }

    public void minusMoney(int money) {
        this.setMoney(this.getMoney() - money);
    }

    public void addCharm(int charm) {
        this.setCharm(this.getCharm() + charm);
    }

    public void minusCharm(int charm) {
        this.setCharm(this.getCharm() - charm);
    }

    @Override
    public String toString() {
        return "■ ■ 내 상태 ■ ■ " + "\n"
                + "[이름] : " + name + "\n"
                + "[나의 매력도] : " + charm + "\n"
                + "[소지품] : " + inventoryStore.toString() + "\n"
                + "[착용한 옷] : " + (equippedItem == null ? "없음" : equippedItem) + "\n"
                + "[소지한 돈] : " + money + "원";
    }
}
