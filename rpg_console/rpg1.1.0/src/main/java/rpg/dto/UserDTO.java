package rpg.dto;

import java.util.InputMismatchException;

public class UserDTO {

    private String name;
    private int charm;
    private Bag bag = new Bag();
    private Item equippedItem;
    private int money;

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

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
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
        if (this.getEquippedItem() != null){
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
                + "[소지품] : " + bag.toString() + "\n"
                + "[착용한 옷] : " +  (equippedItem == null ? "없음" : equippedItem) + "\n"
                + "[소지한 돈] : " + money + "원";
    }
}
