package src_0524;

import java.util.*;
public class src2 {
	public static void main(String []args) {
		int total = 0;
		int count = input("�ο����� �Է��ϼ��� >> "); // input() ȣ��
		for (int i = 0; i < count; i++) {
			int rnd = (int) (Math.random() * 5) + 1;
			int value = valueAt(rnd); // valueAt() �޼ҵ� ȣ��, ������ ��ȯ�޴´�
			String menu = menuAt(rnd); // menuAt() �޼ҵ� ȣ��, �޴��� ��ȯ�޴µ�
			System.out.println("���� : " + rnd + ", �޴� : " + menu + ", ���� : " + value);
			total += value;
		}

		int money = input("�ֹ��հ� : " + total + "  >> "); // input() ȣ��, ����ڷκ��� ���� ���� ��ȯ
		System.out.println("���� �� : " + money);
		System.out.println(money - total != 0 ? "�Ž��� �� : " + (money - total) : "�Ž��� �� ����");
	}

	public static String menuAt(int rnd) {
		// menuAt() �޼ҵ� ���� - ������ ������ �Ű������� �޾� �޴��� ��ȯ�ϴ� �޼ҵ�
		switch(rnd) {
		case 1:
			return "īǪġ��";
		case 2:
			return "����������";
		case 3:
			return "�Ƹ޸�ī��";
		case 4:
			return "ī���";
		case 5:
			return "�ڸ����̵�";
		}
		return null;
	}

	public static int valueAt(int rnd) {
		// valueAt() �޼ҵ� ���� - ������ ������ �Ű������� �޾� ������ ��ȯ�ϴ� �޼ҵ�
		switch(rnd) {
		case 1:
			return 3000;
		case 2:
			return 2000;
		case 3:
			return 2500;
		case 4:
			return 3500;
		case 5:
			return 4000;
		}
		return rnd;
	}

	public static int input(String string) {
		// input() �޼ҵ� ���� -������Ʈ ���ڿ��� �Ű������� ������ 
		//�޼ҵ忡�� �Է� ���� ������ ��ȯ�ϴ� �޼ҵ�
		Scanner scan = new Scanner(System.in);
		System.out.println(string);
		return scan.nextInt();
	}

	
}
