package src_0516;

import java.util.*;
public class src2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array1 = new int [5];
		int i;
		int max = 0;
		int min = 100;
		int MaxIndex = 0;
		int MinIndex = 0;
		
		for(i = 0; i<array1.length; i++) {
			array1[i] = (int)(Math.random()*100)+1;
			if(array1[i]>max) {
				max = array1[i];
				MaxIndex = i+1;
			}if(array1[i]<min) {
				min = array1[i];
				MinIndex = i+1;
			}
		}
		for(int k = 0; k<array1.length; k++) {
			System.out.print(array1[k]+"\t");
		}System.out.println("\n"+"�ִ밪: "+max+"\t"+"�ּҰ�: "+min);
		System.out.println("�ִ밪 �ε���: "+MaxIndex+"\t�ּҰ� �ε���: "+"\t"+MinIndex);
	
}
}