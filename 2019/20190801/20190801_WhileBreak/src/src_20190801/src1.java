/*
 * ���� �Է¹޴� ���α׷�
 */
package src_20190801;

import java.util.*;
public class src1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int month ;
		
		do {
			System.out.println("�ùٸ� ���� �Է��Ͻÿ�. [1-12]");
			month = sc.nextInt();
			
		}while(month<1 ||month>12); {
			//do-while�Ҷ� while ���ǹ� �ڿ� ; ������ ����
		} System.out.println("����ڰ� �Է��� ���� " + month); //���� ����� ������ false �Ǽ� ��������
	} 
	

}