package interfaceEx;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int num;
		Scanner input = new Scanner(System.in);
		Ex01 aaa = new Ex01();
		
		System.out.println("인사관리 프로그램");
		System.out.println("1. 직원 관리");
		System.out.println("2. 학생 관리");
		System.out.println("3. 게시판 관리");
		num = input.nextInt();
		
		switch(num) {
		case 1 : //직원관리 기능 추가(등록, 조회, 검색, 삭제)
			break;
		case 2 : //학생관리 기능 추가(등록, 조회, 검색, 삭제)
			aaa.memu();
			break;
		case 3 : //게시판관리 기능 추가(등록, 조회, 검색, 삭제)
			break;
		}
	}

}
