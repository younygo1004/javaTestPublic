package rpg.dto;

public class GiftShop extends ItemShop {


    public GiftShop() {
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
