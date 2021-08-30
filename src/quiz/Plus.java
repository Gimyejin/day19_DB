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
		System.out.println("�й� �Է�");
		int num = input.nextInt();
		System.out.println("�̸� �Է�");
		String name = input.next();
		System.out.println("�ּ� �Է�");
		String addr = input.next();
		System.out.println("�̸��� �Է�");
		String email = input.next();
		System.out.println("��ȭ��ȣ �Է�");
		String phone = input.next();

		int result = db.insert(num, name, addr, email, phone);
	}

	public void update() {
		System.out.println("������ �̸��� �Է����ּ���.");
		String stname = input.next();
		System.out.println("----------------------");
		System.out.println("������ �ּ�");
		String staddr = input.next();
		System.out.println("������ �̸���");
		String stemail = input.next();
		System.out.println("������ ��ȭ��ȣ");
		String stphone = input.next();

		if (db.update(stname, staddr, stemail, stphone) == 1) {
			System.out.println("������ �Ϸ� �Ǿ����ϴ�");
		} else {
			System.out.println("�ش� �л��� �������� �ʽ��ϴ�");
		}
	}

	public void delete() {
		System.out.println("���� �й� �Է�");
		int stnum = input.nextInt();
		int del = db.delete(stnum);
		if (del == 1) {
			System.out.println("���� �Ǿ����ϴ�");
		} else {
			System.out.println("�ش� �й��� �������� �ʽ��ϴ�");
		}
	}

	public void list() {
		ArrayList<MemberDTO> list = db.getList();
		if (list.size() == 0) {
			System.out.println("����� �����Ͱ� �����ϴ�.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("�й�: " + list.get(i).getNum());
				System.out.println("�̸�: " + list.get(i).getName());
				System.out.println("�ּ�: " + list.get(i).getAddr());
				System.out.println("�̸���: " + list.get(i).getEmail());
				System.out.println("��ȣ: " + list.get(i).getPhone());
			}
		}
	}
}
