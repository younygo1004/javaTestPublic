package rpg.item.dto;

import java.lang.reflect.Array;
import java.util.List;

public abstract class Item {

    private String name;
    private int price;
    private int charm;

    public Item() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public Item(String name, int price, int charm) {
        this.name = name;
        this.price = price;
        this.charm = charm;
    }

    @Override
    public String toString() {
        return name;
    }
}
