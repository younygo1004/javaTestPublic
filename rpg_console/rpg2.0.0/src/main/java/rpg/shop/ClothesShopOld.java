package rpg.shop;

import rpg.item.dto.Clothes;
import rpg.item.dto.Item;

/**
 * 해당 클래스 대신 ItemShop Class 사용!
 */
@Deprecated
public class ClothesShopOld extends ItemShopOld {

    public ClothesShopOld() {
        this.itemList = new Clothes[] {
                new Clothes("정장", 100000, 30),
                new Clothes("셔츠와 청바지", 25000, 5),
                new Clothes("체크 셔츠에 멜빵바지", 15000, -10),
                new Clothes("구찌백", 1000000, -1000)
        };
    }

    @Override
    public Item[] getItemList() {
        return this.itemList;
    }

    @Override
    public Item sellItem(int index) {
        return this.itemList[index];
    }


}
