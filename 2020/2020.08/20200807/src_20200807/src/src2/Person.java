package src2;

public class Person {
	
	private String name;
	private int year = 1998;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	
	void checkMask() {
		int week = year % 10;
		if(year>2020) {
			System.out.println("�߸� �Է� �ϼ̽��ϴ�. ");
		}else {
			if(week == 1 || week == 5) {
				System.out.println("\t"+"Mask: ��");
			}
			
			if(week == 2 || week == 6) {
				System.out.println("\t"+"Mask: ȭ");
			}
			
			if(week == 3 || week == 7) {
				System.out.println("\t"+"Mask: ��");
			}
			
			if(week == 4 || week == 8) {
				System.out.println("\t"+"Mask: ��");
			}
			
			if(week == 5 || week == 9) {
				System.out.println("\t"+"Mask: ��");
			}
		}
	}
	
}