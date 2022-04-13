package interfaceEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Items {

	public void menu() {

		Scanner input = new Scanner(System.in);
		ArrayList<String> it = new ArrayList<String>();
		String item;
		while(true) {
			int num;
			System.out.println("상품 관리 페이지입니다");
			System.out.println("1. 상품 등록");
			System.out.println("2. 상품 조회");
			System.out.println("3. 상품 검색");
			System.out.println("4. 상품 삭제");
			num = input.nextInt();
			switch(num) {
			case 1 :
				System.out.println("등록할 상품을 입력해주세요");
				item = input.next();
				
				if(it.contains(item)!= true) {
					it.add(item);
				}else {
					System.out.println("이미 존재하는 상품입니다.");
				}
				
				break;
			case 2 :
				System.out.println("상품 목록 조회");
				for(int i =0;i<it.size();i++) {
					System.out.println(it.get(i));
				}
				break;
			case 3 :
				System.out.println("검색할 상품 입력 : ");
				item= input.next();
				int i;
				for( i =0; i<it.size();i++) {
					
					if(item.equals(it.get(i))){
						System.out.println("존재하는 상품입니다");
						break;
					}
				}
				if( i == it.size()) {
					System.out.println("존재하지 않습니다");
				}break;
				
			case 4 :
				System.out.println("삭제할 상품 입력 :");
				String name = input.next();
				if(it.contains(name)== true) {
					it.remove(name);
					System.out.println(name+"이 삭제됐습니다");
				}else {
					System.out.println("입력한 상품이 존재하지 않습니다");
				}
				break;
			}
		
	}
	
	}
	
	}
	


