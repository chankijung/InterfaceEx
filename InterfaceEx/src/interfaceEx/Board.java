package interfaceEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

  ArrayList<String> boardBody = new ArrayList<String>();
  int boardNum;
  ArrayList<String> boardTitle = new ArrayList<String>();
  ArrayList<String> boardMaster = new ArrayList<String>();
  Scanner input = new Scanner(System.in);
  String name;

  public void boardWrite() {
    System.out.println("게시글을 작성할 회원을 입력하세요.");
    name = input.next();
    if (list.contains(name) == false) {
      System.out.println("존재하지 않는 회원입니다.");
      break;
    } else {
      System.out.println(
        name + "회원의 이름으로 작성할 글의 제목을 입력하세요."
      );
      String title = input.next();
      System.out.println("글의 내용을 입력하세요.");
      String body = input.next();
      boardTitle.add(title);
      boardBody.add(body);
      boardMaster.add(name);
      System.out.println("글 작성이 완료되었습니다.");
    }
  }

  public void boardRead() {
    System.out.println(
      "1~" +
      boardTitle.size() +
      "번까지 글이 있습니다. 보고싶은 글의 번호를 입력해주세요."
    );
    int num = input.nextInt();
    if (num > boardTitle.size() || num <= 0) {
      System.out.println("잘못된 접근입니다.");
    } else {
      System.out.println("글 번호: " + num);
      System.out.println("글쓴이: " + boardMaster.get(num));
      System.out.println("제목: " + boardTitle.get(num));
      System.out.println("내용: " + boardBody.get(num));
    }
  }

  public void boardRemove() {
    System.out.println("삭제할 글 번호를 입력하세요.");
    int num = input.nextInt();
    if (num > boardTitle.size() || num <= 0) {
      System.out.println("잘못된 접근입니다.");
    } else {
      boardMaster.remove(num);
      boardTitle.remove(num);
      boardBody.remove(num);
      System.out.println("삭제가 완료되었습니다.");
    }
  }

  public void boardShow() {
    System.out.println("1. 글 쓰기\t2. 글 읽기\t3. 글 삭제");
    int menu = input.nextInt();
    switch (menu) {
      case 1:
        boardWrite();
        break;
      case 2:
        boardRead();
        break;
      case 3:
        boardRemove();
        break;
      default:
        System.out.println("잘못된 접근입니다.");
        break;
    }
  }
}
