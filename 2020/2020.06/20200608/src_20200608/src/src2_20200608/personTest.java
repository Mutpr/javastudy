package src2_20200608;

import java.util.*;
public class personTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		person p = new person();
		
		System.out.println("�̸��� ��� �⵵�� �Է��ϼ���.");
		
		p.setPerson(scan.nextLine());
		p.getYear(scan.nextInt());
		
		p.getPerson();
		p.checkMask();
		
	}

}