package src1_20201105;

import java.util.*;
public class Answer_01 {
	public static void main(String[] args) {
		//charAt(int a)
		Scanner scan = new Scanner(System.in);
		String str = "�ڹ� ���α׷��� ��̾����ϴ�. ��ƽ��ϴ�.";
		char ch= scan.next().charAt(0);
		for(int i=0; i<str.length(); i++) {
			if(ch == str.charAt(i)) {
				System.out.println(ch+"��"+(i+1)+"�ڸ��� �ֽ��ϴ�.");
				System.out.println("���α׷� ����");
				break;
			}else if(ch != str.charAt(i)){
				System.out.println(ch+"�� ���ڿ��� �����ϴ�");
				System.out.println("���α׷� ����");
				break;
			}
		}
		
	}

}