package src1_20201102;

public class Hair extends Tool{
	private String style;
	
	public Hair(String type, String style) {
		super(type);
		this.style = style;
	}
	
	void tint(String color) {
		System.out.println(super.getType()+color+" ������ �����մϴ�");
	}
	
	@Override
	public void cut() {
		System.out.println(super.getType()+" �� �ڸ���.");
	}
	
	@Override
	public void dry() {
		System.out.println(super.getType()+" �� ������.");
	}
	
	@Override
	void write() {
		super.write();
		System.out.println("Style>> "+style);
	}
	}