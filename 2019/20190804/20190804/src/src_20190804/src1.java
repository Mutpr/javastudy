/*
 * ���� ���� ����:3
 */
package src_20190804;

import java.util.*;
public class src1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); //��ĳ�� ��ü �ҷ���
		
		int guess;//�Է��� ����
		int answer = 67; //����, answer�� �Է��ϴ� ���ڷ� �� �� �ְ���
		int tries = 0; // ������ Ƚ���� ������ ���� ���� tries
		
		do {
			System.out.println("������ �����Ͽ� ���ÿ�:");
			guess = sc.nextInt();
			tries++; //do-while�� ���ư� Ƚ���� ǥ���Ѵ�.(������ �ѹ��� ���� ������ 1���� ����) 
			
			if(guess > answer) { //�Է��� ���ڰ� ���亸�� ũ�ٸ�
				System.out.println("������ ���ڰ� ���亸�� Ů�ϴ�.");
			}
			if(guess < answer) { //�Է��� ���ڰ� ���亸�� �۴ٸ�
				System.out.println("������ ���ڰ� ���亸�� �۽��ϴ�.");
			}
			
		} while(!(answer==guess)); //�Է��� ���ڿ� ������ ���ٸ� false�� �ٲپ� do-while���� ����������.
		System.out.println("�����մϴ�! �����Դϴ�. ��");
		System.out.println("�õ��� Ƚ��: " + tries);
		
	}

}