package ex1_220109;

import java.util.*;

public class ex1_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ex1_method method = new ex1_method();

		System.out.println("��ڼ�: ");
		int num = scan.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			x[i] = scan.nextInt();
		}
		System.out.println("�˻���: ");
		int key = scan.nextInt();

		int xd = method.seqsearch(x, num, key);
		if(xd == 1) {
			System.out.println("ã�°� �ֽ��ϴ�.");
		}else {
			System.out.println("ã�°� �����ϴ�.");
		}
		
		method.indexsearch(x, num, key);
		scan.close();
	}

}