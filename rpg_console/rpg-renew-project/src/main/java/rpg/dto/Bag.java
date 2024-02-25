package rpg.dto;

import java.util.ArrayList;
import java.util.List;

public class Bag {

//    private ArrayList<Item> itemList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    public Bag() {}

    @Deprecated
    public void printBag() {
        for(Item item : itemList) {
            System.out.println(item + "/" + "나의 매력도 강화 : " + item.getCharm());
        }
    }

    @Deprecated
    public void printGiftItem() {
        for(Item item : itemList) {
            if(item instanceof Gift) {
                System.out.println(item);
            }
        }
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public List<Gift> getGiftList() {
        List<Gift> giftList = new ArrayList<>();
        for(Item item : itemList) {
            if (item instanceof Gift) giftList.add((Gift) item);
        }
        return giftList;
    }


    public void addItem(Item item) {
        itemList.add(item);
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Item item : itemList) {
            s.append(item.getName()).append(", ");
        }

        return s.toString();
    }
}
