/*
 * �� ���� A�� B�� �Է� ���� ����, A+B�� 
 */

package Forsrc_20200212;

import java.util.*;
public class src_FOR_NO2 {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		for(int k = 1; k<=number; k++) { 
			int i = scan.nextInt();
			int j = scan.nextInt();
			System.out.println(i+j);
		}
	}

}