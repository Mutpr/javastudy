package lecto2;

public class EXTest {
	public static void main(String[] args) {
		GetterSetterEX c1 = new GetterSetterEX(100,50);
		GetterSetterEX c2 = new GetterSetterEX(60,60);
		
		c1.print("c1");
		c2.print("c2");
		c2.setMileage(90);
		c2.print("c2");
		System.out.println("c1 �ӵ�: "+c1.getSpeed());
	}
}