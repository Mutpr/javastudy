package pack1_0716;

import java.util.*; 

public class src7 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); //��ĳ�� �޾���
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		for(int i = 0; i<=a; i++) { //�ʱⰪ�� 0���� �������ش�. 1�� �����ϸ� �� �ϳ� ����..
			for(int j = 0; j<=i; j++) //�� j�� i���� ũ�� �ȵɱ�?
				System.out.print("*"); //*�� ����Ʈ �ϰ� ����
				System.out.println(""); //���� ����ش�.
		}
	}
}