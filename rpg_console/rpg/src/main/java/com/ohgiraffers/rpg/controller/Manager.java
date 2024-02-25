package com.ohgiraffers.rpg.controller;



import com.ohgiraffers.rpg.dto.*;

import java.util.List;
import java.util.Scanner;

public class Manager {

    Scanner sc = new Scanner(System.in);

    private UserDTO userDTO = new UserDTO();
    private PersonDTO[] npcList = new PersonDTO[]{
            new PersonDTO("한미녀", -20),
            new PersonDTO("구동매", 0),
            new PersonDTO("우영우", 15)
    };

    public Manager() {
    }

    public void setUserName(String name) {
        userDTO.setName(name);
    }

    public void alba(int type) {
        switch (type) {
            case 1:
                System.out.println("편의점 알바를 했다.");
                System.out.println("진상이 너무 많다............");
                System.out.println("총 10000원을 벌었다.");
                userDTO.setMoney(userDTO.getMoney() + 10000);
                System.out.println("나의 매력이 20 하락했다.");
                userDTO.setCharm(userDTO.getCharm() - 20);
                break;
            case 2:
                System.out.println("영화관 알바를 했다.");
                System.out.println("메뚜기족들 잡느라 너무 힘들다........");
                System.out.println("총 25000원을 벌었다.");
                userDTO.setMoney(userDTO.getMoney() + 25000);
                System.out.println("나의 매력이 10 하락했다.");
                userDTO.setCharm(userDTO.getCharm() - 10);
                break;
            case 3:
                System.out.println("식당 알바를 했다.");
                System.out.println("손님이 팁을 만원 주셨다!");
                System.out.println("총 30000원을 벌었다.");
                userDTO.setMoney(userDTO.getMoney() + 30000);
                System.out.println("나의 매력이 5 하락했다.");
                userDTO.setCharm(userDTO.getCharm() - 5);
                break;

        }
    }

    public void printUserStatus() {
        System.out.println(userDTO);
    }

    public void printEqI() {
        System.out.println(userDTO.getEquipmentsItem());
    }

    public void haveItems() {
        userDTO.getBag().printBag();
    }

    public void buyAllItem(int type) {
        switch (type) {
            case 1:
                if (userDTO.getEquipmentsItem() == null) {
                    System.out.println("옷 가게에 입장했다 !");
                    System.out.println("============================");
                    System.out.println("중년의 주인장이 나타났다 ...");
                    System.out.println("주인장 : 어떤 물건을 구입하시겠습니까?");
                    System.out.println("============================");
                    ClothesShop cs = new ClothesShop();
                    cs.showItems();
                    System.out.println("============================");
                    System.out.print("어느 물건을 달라 할까? : ");
                    int selectClothes = sc.nextInt() - 1;
                    Item item = cs.sellItem(selectClothes);
                    if (userDTO.getMoney() < item.getPrice()) {
                        System.out.println("돈이 없다. 아르바이트를 하러 가볼까?");
                        return;
                    } else {
                        userDTO.getBag().hiItem(item);
                        if (item instanceof Clothes) {
                            userDTO.setEquipmentsItem(item);
                            userDTO.setCharm(userDTO.getCharm() + item.getCharm());
                            System.out.println();
                            System.out.println("매력도가 " + userDTO.getCharm() + "가 되었다!");
                            System.out.println(item.getPrice() + "원 사용했다.");
                            userDTO.setMoney(userDTO.getMoney() - item.getPrice());
                            System.out.println(userDTO.getMoney() + "원 남았다.");
                        }
                        System.out.println((cs.sellItem(selectClothes)).getName() + "을/를 샀다 !");
                    }
                } else {
                    System.out.println("돈을 벌어야 한다.");
                }
                break;
            case 2:
                System.out.println("선물 가게에 입장했다 !");
                System.out.println("============================");
                System.out.println("야생의 산신령이 나타났다 ...");
                System.out.println("야생의 산신령 : 어떤 물건이 네 물건이냐?");
                System.out.println("============================");
                GiftShop gs = new GiftShop();
                gs.showItems();
                System.out.println("============================");
                System.out.print("어느 물건을 달라 할까? : ");
                int selectGift = sc.nextInt() - 1;
                Item item = gs.sellItem(selectGift);
                if (userDTO.getMoney() < item.getPrice()) {
                    System.out.println("돈이 없다. 아르바이트를 하러 가볼까?");
                    return;
                } else {
                    userDTO.getBag().hiItem(item);
                    System.out.println(item.getPrice() + "원 사용했다.");
                    userDTO.setMoney(userDTO.getMoney() - item.getPrice());
                    System.out.println(userDTO.getMoney() + "원 남았다.");
                    System.out.println((gs.sellItem(selectGift)).getName() + "을/를 샀다 !");
                }
                break;
        }

    }

    public void printCharm() {
        for (PersonDTO npc : npcList) {
            System.out.println(npc);
        }
    }

    public Item getEqItElement() {
        return userDTO.getEquipmentsItem();
    }

    public void talk(int npcNum) {
        int index = npcNum - 1;
        PersonDTO selectedNPC = npcList[index];
        System.out.println(selectedNPC.getName() + "을/를 만났다!");
        System.out.println("============================");
        System.out.println("[1] 오늘 날씨 어때?");
        System.out.println("[2] 우리 놀러갈래?");
        System.out.println("[3] 어제 뭐 먹고 잤니..?");
        System.out.println("[4] 선물을 준다..");
        System.out.println("[5] 아무 것도 하지 않는다...");
        System.out.println("============================");
        System.out.print("무엇을 할까? :");
        int talkSelectNum = sc.nextInt();
        sc.nextLine();
        switch (talkSelectNum) {
            case 1:
                System.out.println(userDTO.getName() + ": 오늘 날씨 어때?");
                System.out.println(selectedNPC.getName() + ": 화창한걸!");
                selectedNPC.setLike(selectedNPC.getLike() + 20 + userDTO.getCharm());
                System.out.println(selectedNPC.getName() + "의 호감도가 " + (20 + userDTO.getCharm()) + " 만큼 변화했다...");
                break;
            case 2:
                System.out.println(userDTO.getName() + ": 우리 놀러갈래?!");
                if (selectedNPC.getLike() > 50) {
                    System.out.println(selectedNPC.getName() + ": 좋아! 어디로 갈까?");
                    System.out.println("둘은 어디로 놀러갈지 대화하기 시작했다...");
                } else {
                    System.out.println(selectedNPC.getName() + ": 우리가..?");
                    System.out.println(userDTO.getName() + " 은/는 버려졌다....");
                }
                break;
            case 3:
                System.out.println(userDTO.getName() + ": 어제 뭐 먹고 잤니..?");
                System.out.println(selectedNPC.getName() + ": 뭐?");
                selectedNPC.setLike(selectedNPC.getLike() - 100);
                System.out.println(selectedNPC.getName() + "의 호감도가 100 내려갔다...");
                break;
            case 4:
                System.out.println("가지고 있는 선물");
                System.out.println("============================");
                userDTO.getBag().printGiftItem();
                System.out.println("무엇을 줄까? : ");
                int selectGift = sc.nextInt();
                sc.nextLine();
                List<Gift> userGiftList = userDTO.getBag().getGiftList();
                int giftIndex = selectGift - 1;
                Gift givenGift = userGiftList.get(giftIndex);
                userDTO.getBag().byeItem(givenGift);
                System.out.println(selectedNPC.getName() + "의 호감도가 " + (30 + givenGift.getCharm() + userDTO.getCharm()) + "만큼 변화했다...");
                selectedNPC.setLike(selectedNPC.getLike() + 30 + givenGift.getCharm() + userDTO.getCharm());
                break;
            case 5:
                System.out.println("아무 일도 일어나지 않았다.....");
                break;
        }
    }


}
