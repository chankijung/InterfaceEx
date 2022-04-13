package interfaceEx;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class BoardDetail {

  private String name;
  private String body;
  private String title;
  private int num;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getNum() {
    return this.num;
  }
}

class BoardSaver {

  String workPath = System.getProperty("user.dir");

  public void SaveFunc(String s1, String s2, String s3, int num) {
    File F = new File(workPath + "\\" + num + ".txt");
    try {
      FileOutputStream Saver = new FileOutputStream(F);
      BufferedOutputStream bos = new BufferedOutputStream(Saver);
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      BoardDetail bd = new BoardDetail();
      bd.setName(s1);
      bd.setTitle(s2);
      bd.setBody(s3);
      bd.setNum(num);
      oos.writeObject(bd);
      oos.close();
    } catch (Exception e) {}
  }

  public void LoadFunc(int num) {
    File F = new File(workPath + "\\" + num + ".txt");
    try {
      FileInputStream Loader = new FileInputStream(F);
      BufferedInputStream bis = new BufferedInputStream(Loader);
      ObjectInputStream ois = new ObjectInputStream(bis);
      BoardDetail bd = (BoardDetail) ois.readObject();
      System.out.println("글쓴이: " + bd.getName());
      System.out.println("제목: " + bd.getTitle());
      System.out.println("내용: " + bd.getBody());
      ois.close();
    } catch (Exception e) {}
  }

  public class Board extends BoardSaver {

    ArrayList<String> boardBody = new ArrayList<String>();
    int boardNum;
    ArrayList<String> boardTitle = new ArrayList<String>();
    ArrayList<String> boardMaster = new ArrayList<String>();
    Scanner input = new Scanner(System.in);
    String name;

    public void boardWrite() {
      System.out.println("게시글을 작성할 회원을 입력하세요.");
      name = input.next();
      System.out.println(
        name + "회원의 이름으로 작성할 글의 제목을 입력하세요."
      );
      String title = input.next();
      System.out.println("글의 내용을 입력하세요.");
      String body = input.next();
      boardTitle.add(title);
      boardBody.add(body);
      boardMaster.add(name);
      SaveFunc(name, title, body, boardMaster.indexOf(name));
      System.out.println("글 작성이 완료되었습니다.");
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
        LoadFunc(num);
        /*System.out.println("글 번호: " + num);
      System.out.println("글쓴이: " + boardMaster.get(num));
      System.out.println("제목: " + boardTitle.get(num));
      System.out.println("내용: " + boardBody.get(num));
      */
      }
    }

    public void boardRemove() {
      System.out.println("삭제할 글 번호를 입력하세요.");
      int num = input.nextInt();
      if (num > boardTitle.size() || num <= 0) {
        System.out.println("잘못된 접근입니다.");
      } else {
        File F = new File(workPath + "\\" + num + ".txt");
        F.delete();
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
}
