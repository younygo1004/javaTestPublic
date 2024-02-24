package rpg.view;


import rpg.controller.Manager;

import java.util.Scanner;

/*
 * 리팩토링 목표
 * - 현재의 요구사항이 아닌, 미래의 요구사항을 가정하여 만들 것이다.
 * - 따라서 Over Engineering된 프로젝트가 생성될 수 있으므로, 감안하고 보도록 하자.
 * - Super Type Token을 이용한 리팩토링까지 끝난 후, 새로운 요구사항들을 만들어 비교하는 것이 최종 목표이다.
 *
 *
 *  리팩토링 계획
 *  1. 로직을 Method로 분리하자.
 *  2. Interface를 사용할 수 있는 필드는 구현체 대신 Interface를 사용하자.
 *  3. Shop 객체 (ClothesShop, GiftShop)의 공통 기능을 강제하도록 Interface를 사용하자
 *  3-1. Shop을 단계별로 수정하여 최종적으로는 Type-Safety를 최대한 보장하도록 하자.
 *  4. 문서화는 필수다.
 *  5. 변수의 이름을 제대로 짓자.
 *  6. 프로젝트의 구조를 최대한 수정하지 않고, 확장성을 최대한 높여보자
 *  7. 현재 Controller단과 View 단의 경계가 모호하다.
 *  7-1. 따라서 Controller를 Server / View를 Client라고 가정하고 로직을 분리하도록 하자.
 *  8. 각 DTO의 데이터 수정은 최대한 DTO 내에서 진행하도록 하자.
 *  9. 패키지 구조를 조금 더 명확하게 만들도록 하자.
 *  10. 기존 클래스를 변경된 클래스로 대체하고, 기존 클래스에는 @Deprecated Annotation을 붙여 경고를 주자.
 *  11. 모든 객체, 모든 필드는 최대한 final, private로 기술하고, setter 또한 최대한 지양하도록 하자.
 *  11-1. 그 이유는 최대한 불변성을 보장하기 위함이다.
 *
 *  기타
 *  - rpg-renew-project에서는 최대한 Generic을 덜 사용할 것이다.
 *  - 그 이유는 Generic을 사용했을 때와 다시 비교하기 위함이다.
 *  - Generic을 사용한 기법은 rpg-renewal-generic-project라는 이름으로 새롭게 만들 것이다.
 *
 */

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
                    System.out.println("1. 금혁수 / 2. 구자윤 / 3. 조현");
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
