package src3_20200608;

import java.util.*;
public class bookTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		book book1 = new book();
		book book2 = new book();
		
		System.out.println("�����̿� ������ �Է��ϼ���:");
		book1.setAuthor(scan.nextLine());
		book1.setName(scan.nextLine());
		
		System.out.println("�����̿� ������ �Է��ϼ���:");
		book2.setAuthor(scan.nextLine());
		book2.setName(scan.nextLine());
		
		System.out.println(book1.toString());
		System.out.println(book2.toString());
	
	}

}