package rpg.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClothesShop {

    private final Clothes[] clothesList = new Clothes[4];

    public ClothesShop() {
        clothesList[0] = new Clothes("정장", 100000, 30);
        clothesList[1] = new Clothes("셔츠와 청바지", 25000, 5);
        clothesList[2] = new Clothes("체크 셔츠에 멜빵바지", 15000, -10);
        clothesList[3] = new Clothes("구찌백", 1000000, -1000);
    }

    public void showItems() {
        for(int i = 0; i < clothesList.length; i++) {
            System.out.println("[" + (i+1) + "] " + clothesList[i]
                    + " / 가격 : " + clothesList[i].getPrice()
                    + " / 매력도 : " + clothesList[i].getCharm());
        }
    }

    public Clothes sellItem(int index) {
        return clothesList[index];
    }



}
