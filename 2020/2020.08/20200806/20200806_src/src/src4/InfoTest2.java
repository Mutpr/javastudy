package src4;

import java.util.*;
public class InfoTest2 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		Info info1 = new Info();
		Info info2 = new Info();
		
		System.out.println("���̵� �Է��ϼ���>> ");
		info1.id = scan.nextLine();
		System.out.println("ù��° ��ü ���� �Ϸ�");
		
		System.out.println("���̵� �Է��ϼ���>> ");
		info2.id = scan.nextLine();
		System.out.println("�ι�° ��ü ���� �Ϸ�");
		
		System.out.println("ù��° ��ü�� ���̵�� ��й�ȣ ���");
		info1.disPlay();
		
		System.out.println("�ι�° ��ü�� ���̵�� ��й�ȣ ���");
		info2.disPlay();
	}
}