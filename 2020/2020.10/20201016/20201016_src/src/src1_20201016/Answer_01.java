package src1_20201016;

import java.util.*;

public class Answer_01 {
	public static void main(String[] args) {
		int [] data = new int[10];
		data = init(data);
		
		System.out.println("�ʱ�ȭ�� �迭 ���");
		for(int temp:data)
			System.out.print(temp + "\t");
		System.out.println();
		System.out.println("�������� ���");
		reverse(data);
	}
	
	public static int[] init(int [] arr) {	  
		int[] array1 = new int [arr.length];
		for(int i = 0; i<=array1.length-1; i++) {
			array1[i] = ((int)(Math.random()*100));
		}
		return array1;
	}
	
	public static void reverse(int [] arr) {
		int [] array1;
		array1 = arr;
		for(int i=array1.length-1; i>=0; i--) {
			System.out.print(array1[i]+"\t");
		}
	}
	
}