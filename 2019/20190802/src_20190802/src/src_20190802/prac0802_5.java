package src_20190802;

import java.util.*;

public class prac0802_5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		int balance = 0;
		
		while(run) {
			System.out.println("-----------------------");
			System.out.println("1.���� | 2.���|3.�ܰ�|4.����");
			System.out.println("-----------------------");
			System.out.println("����>");
			
			int menuNum = sc.nextInt();//���
			int depos =0;
			int number=0;
			
			switch(menuNum) {
			case 1: //���ݾ� �Է�
				System.out.print("���ݾ�>");
				balance += sc.nextInt();
				break;
				
			case 2://��ݾ� �Է�
				System.out.print("��ݾ�>");//��ݾ�
				balance -= sc.nextInt(); //�а����� �ܰ����� ���� ����
				break;
				
			case 3://�ܰ� ���
				System.out.print("�ܰ�>");
				System.out.println(balance);
				break;
				
			case 4:
				run = false; //4���� �����ϸ� false�� �Ǽ� while���� ���������� ��!
				break; //���� �� �־��൵ ��!
			}
			System.out.println();
		}
		System.out.println("�ý��� ����");
	}
}