package lector1;

public class informationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		information info1 = new information();
		information info2 = new information("linux");
		information info3 = new information("Unix",5674);
		
		System.out.println("info1: "+info1);
		System.out.println("info2: "+info2);
		System.out.println("info3: "+info3);
		
		info2.setPass(8549);
		System.out.println("���� �� info2: "+ info2);
	}

}