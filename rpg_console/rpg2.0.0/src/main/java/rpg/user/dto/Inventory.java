package rpg.user.dto;

import rpg.item.dto.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> {

    private final List<T> itemList;

    public Inventory() {
        this.itemList = new ArrayList<>();
    }
}
