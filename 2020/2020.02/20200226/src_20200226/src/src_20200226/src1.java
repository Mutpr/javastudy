package src_20200226;

/*
 * ����:���� N���� �̷���� ���� A�� ���� X�� �־�����. �̶�, 
 * A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Է�:ù° �ٿ� N�� X�� �־�����. (1 �� N, X �� 10,000)
	��° �ٿ� ���� A�� �̷�� ���� N���� �־�����. 
	�־����� ������ ��� 1���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̴�.
	���: X���� ���� ���� �Է¹��� ������� �������� ������ ����Ѵ�. 
	X���� ���� ���� ��� �ϳ� �����Ѵ�.
	
 */

import java.util.*;
public class src1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int x = scan.nextInt();
		int [] A = new int[n];
		int i;
		
		for(i=0; i<=A.length; i++) {
			A[i] = scan.nextInt();
			if(A[i]<x){
				System.out.print(A[i]);
		}
			}
		
		
//		for(int i=start; i<=n; i++) {
//			if()
//		}
	}

}