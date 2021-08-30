package quiz;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Plus plus =new Plus();
		while (true) {
			System.out.println("1.회원 추가 2.회원 수정 3.회원 삭제 4.회원 목록 5.종료");
			int num = input.nextInt();
			switch (num) {
			case 1:plus.insert();
				break;
			case 2:plus.update();
				break;
			case 3:plus.delete();
				break;
			case 4:plus.list();
				break;
			case 5: System.exit(1);
			}
		}
	}

}
