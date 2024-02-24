package com.ohgiraffers.rpg.view;



import com.ohgiraffers.rpg.controller.Manager;

import java.util.Scanner;

public class Menu {

    public Menu() {}
    private Scanner sc = new Scanner(System.in);
    private Manager manager = new Manager();

    public void menu() {
        while (true) {
            System.out.println("============ 메뉴 ============");
            System.out.println("1. 내 이름 설정하기");
            System.out.println("2. 내 상태 확인하기");
            System.out.println("3. 소지품 보기");
            System.out.println("4. 대화하기");
            System.out.println("5. 쇼핑하기");
            System.out.println("6. 아르바이트 하기");
            System.out.println("7. 호감도 확인하기");
            System.out.println("8. 종료");
            System.out.println("============================");
            System.out.print("번호를 선택하세요 : ");
            int selectNum = sc.nextInt();
            sc.nextLine();

            switch (selectNum) {
                case 1:
                    System.out.print("내 이름 설정하기 : ");
                    String name = sc.nextLine();
                    manager.setUserName(name);
                    break;
                case 2: manager.printUserStatus();
                    break;
                case 3:
                    System.out.println("착용 중인 아이템 =============");
                    manager.printEqI();
                    System.out.println("소지품 ======================");
                    manager.haveItems();
                    break;
                case 4:
                    System.out.println("1. 한미녀 / 2. 구동매 / 3. 우영우");
                    System.out.println("============================");
                    System.out.print("누구랑 대화할까? : ");
                    int selectTalk = sc.nextInt();
                    sc.nextLine();
                    manager.talk(selectTalk);
                    break;
                case 5:
                    System.out.println("1. 옷 가게 / 2. 선물 가게");
                    System.out.println("============================");
                    System.out.print("어느 가게로 가시겠습니까? : ");
                    int selectNum3 = sc.nextInt();
                    sc.nextLine();
                    manager.buyAllItem(selectNum3);
                    break;
                case 6:
                    System.out.println("어느 아르바이트를 하러 갈까?");
                    System.out.println("1. 편의점 / 2. 영화관 / 3. 식당");
                    System.out.println("============================");
                    System.out.print("번호를 선택하세요 : ");
                    int selectNum2 = sc.nextInt();
                    sc.nextLine();
                    manager.alba(selectNum2);
                    break;
                case 7:
                    manager.printCharm();
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

}
