package rpg.dto;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private ArrayList<Item> bag = new ArrayList<>();
    public Bag() {}

    public void printBag() {
        for(Item item : bag) {
            System.out.println(item + "/" + "나의 매력도 강화 : " + item.getCharm());
        }
    }

    public void printGiftItem() {
        for(Item item : bag) {
            if(item instanceof Gift) {
                System.out.println(item);
            }
        }
    }

    public List<Gift> getGiftList() {
        List<Gift> giftList = new ArrayList<>();
        for(Item item : bag) {
            if (item instanceof Gift) giftList.add((Gift) item);
        }
        return giftList;
    }


    public void hiItem(Item item) {
        bag.add(item);
    }

    public void byeItem(Item item) {
        bag.remove(item);
    }

    public String toString() {
        String s = "";

        for (Item item : bag) {
            s += item.getName() + ", ";
        }

        return s;
    }
}
