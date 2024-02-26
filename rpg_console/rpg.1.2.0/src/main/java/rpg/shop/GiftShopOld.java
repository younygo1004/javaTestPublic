package rpg.shop;

import rpg.item.dto.Gift;
import rpg.item.dto.Item;

/**
 * 해당 Class 대신 ItemShop Class 사용!
 */
@Deprecated
public class GiftShopOld extends ItemShopOld {


    public GiftShopOld() {
        this.itemList = new Gift[]{
                new Gift("꽃다발", 30000, 20),
                new Gift("케이크", 45000, 30),
                new Gift("발가락 양말", 3000, -20),
                new Gift("슈퍼카", 100000000, -1000)
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
