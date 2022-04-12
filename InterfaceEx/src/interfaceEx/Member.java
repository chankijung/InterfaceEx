package interfaceEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

  public void menu() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    while (true) {
      System.out.println("1. 회원 등록\t2. 회원 조회\t3.회원 검색\t4. 삭제");
      System.out.print(">>>>:");
      int choice = input.nextInt();

      switch (choice) {
        case 1:
          System.out.println("회원을 등록합니다");
          System.out.print("이름 입력:");
          String name = input.next();
          list.add(name);
          break;
        case 2:
          for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
          }
          break;
        case 3:
          System.out.println("검색할 회원 이름을 입력하세요.");
          System.out.print("이름 입력: ");
          String name2 = input.next();
          if (list.contains(name2) == true) {
            System.out.println("이 회원은 가입되어 있습니다.");
          } else {
            System.out.println("이 회원은 가입되어 있지 않습니다.");
          }
          break;
        case 4:
          System.out.println("삭제할 회원 이름을 입력하세요.");
          System.out.print("이름 입력: ");
          String name3 = input.next();
          if (list.contains(name3) == true) {
            list.remove(name3);
            System.out.println(name3 + "회원이 삭제되었습니다.");
          } else {
            System.out.println("입력한 회원이 존재하지 않습니다.");
          }
          break;
        default:
          System.out.println("잘못된 입력입니다.");
          break;
      }
    }
  }
}
