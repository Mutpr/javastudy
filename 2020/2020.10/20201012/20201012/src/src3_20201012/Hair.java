package src3_20201012;

public class Hair implements Operation{
	private String type;
	
	public Hair(String type) {
		this.type = type;
	}
	
	static void tint(String color) {
		System.out.println(color+" ������ �����ϴ�.");
	}

	@Override
	public void cut() {
		System.out.println(type +" �� �ڸ���.");
		
	}

	@Override
	public void wash() {
		System.out.println(type+" �� �Ĵ�.");
		
	}
}