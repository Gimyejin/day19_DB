package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Plus {
	Scanner input = new Scanner(System.in);
	DBClass db;

	public Plus() {
		db = new DBClass();
	}

	public void insert() {
		System.out.println("학번 입력");
		int num = input.nextInt();
		System.out.println("이름 입력");
		String name = input.next();
		System.out.println("주소 입력");
		String addr = input.next();
		System.out.println("이메일 입력");
		String email = input.next();
		System.out.println("전화번호 입력");
		String phone = input.next();

		int result = db.insert(num, name, addr, email, phone);
	}

	public void update() {
		System.out.println("수정할 이름을 입력해주세요.");
		String stname = input.next();
		System.out.println("----------------------");
		System.out.println("수정할 주소");
		String staddr = input.next();
		System.out.println("수정할 이메일");
		String stemail = input.next();
		System.out.println("수정할 전화번호");
		String stphone = input.next();

		if (db.update(stname, staddr, stemail, stphone) == 1) {
			System.out.println("수정이 완료 되었습니다");
		} else {
			System.out.println("해당 학생은 존재하지 않습니다");
		}
	}

	public void delete() {
		System.out.println("삭제 학번 입력");
		int stnum = input.nextInt();
		int del = db.delete(stnum);
		if (del == 1) {
			System.out.println("삭제 되었습니다");
		} else {
			System.out.println("해당 학번은 존재하지 않습니다");
		}
	}

	public void list() {
		ArrayList<MemberDTO> list = db.getList();
		if (list.size() == 0) {
			System.out.println("저장된 데이터가 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("학번: " + list.get(i).getNum());
				System.out.println("이름: " + list.get(i).getName());
				System.out.println("주소: " + list.get(i).getAddr());
				System.out.println("이메일: " + list.get(i).getEmail());
				System.out.println("번호: " + list.get(i).getPhone());
			}
		}
	}
}
