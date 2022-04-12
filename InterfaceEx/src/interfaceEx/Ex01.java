package interfaceEx;
import java.util.ArrayList;
import java.util.Scanner;


class 이름{
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class 학번{
	public int Studentid;

	public int getStudentid() {
		return Studentid;
	}

	public void setStudentid(int studentid) {
		Studentid = studentid;
	}

}

public class Ex01 {
public void memu(){

	ArrayList<이름> arr = new ArrayList<이름>();
	ArrayList<학번> arr2 = new ArrayList<학번>();
	Scanner sc = new Scanner(System.in);
	int num;
	int id = 0;
	boolean on=true;
	
	String name;
	while(on=true) {
	System.out.println("1. 이름 학번 등록");
	System.out.println("2. 전체 이름 학번 조회");
	System.out.println("3. 이름 학번 검색");
	System.out.println("4. 이름 학번 삭제");
	System.out.println("5. 종료");
	num=sc.nextInt();
	
	
	switch(num){
	case 1: 
		System.out.println("이름 입력");
		이름 n = new 이름();
		name = sc.next();
		n.setName(name);
		arr.add(n);
		
		System.out.println("학번 입력");
		학번 b = new 학번();
		id=sc.nextInt();
		b.setStudentid(id);
		arr2.add(b);
		break;
	
	case 2: 
		for(int i = 0 ; i<arr.size();i++) {
			System.out.println(arr.get(i).getName());
		}
		for(int i = 0; i<arr2.size();i++) {
			System.out.println(arr2.get(i).getStudentid());
		}
		break;
		
	case 3: 
		System.out.println("입력 : ");
		name = sc.next();
		int i;
		for(i=0;i<arr.size();i++) {
			이름 nn = arr.get(i);
			if(name.equals(nn.getName())) {
			System.out.println("존재함");
			}
			else System.out.println("존재하지 않음");
			}
		break;
		
	case 4: 
		System.out.println("삭제할 이름 입력 : ");
		name = sc.next();
		for(i=0;i<arr.size();i++) {
			이름 aa = arr.get(i);
			if(aa.name.equals(name) ==true) {
		arr.remove(i);
		System.out.println(name+"삭제됨");
		}
		}
		break;
	case 5: on=false;
	break;
	}
	}
	System.out.println("종료합니다");

}
}
