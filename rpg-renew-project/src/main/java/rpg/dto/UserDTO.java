package rpg.dto;

public class UserDTO {

    private String name;
    private int charm;
    private Bag bag = new Bag();
    private Item equipmentsItem;
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

    public Item getEquipmentsItem() {
        return equipmentsItem;
    }

    public void setEquipmentsItem(Item equipmentsItem) {
        this.equipmentsItem = equipmentsItem;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void wearOn(Item item) {
        this.setEquipmentsItem(item);
        this.setCharm(this.getCharm() + item.getCharm());
    }

    public void makeMoney(int money) {
        this.setMoney(this.getMoney() + money);
    }

    @Override
    public String toString() {
        return "■ ■ 내 상태 ■ ■ " + "\n"
                + "[이름] : " + name + "\n"
                + "[나의 매력도] : " + charm + "\n"
                + "[소지품] : " + bag.toString() + "\n"
                + "[착용한 옷] : " + equipmentsItem + "\n"
                + "[소지한 돈] : " + money + "원";
    }
}
