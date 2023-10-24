package src1;

class Melon extends Food { //food ����ϴ� melon Ŭ���� �ۼ�
	private String info; //���� ��� ����
	
	public Melon(int cost, int kg, String info) { //������ �Ű�����
		//���ݰ� �߷� ���� �� �޾� ��
		//�θ� Ŭ������ �Ű����� ���� �޾ƿͼ� �ʿ��� �� ����
		super(cost,kg); //Food �� ������ ȣ��
		this.info = info; 
	}
	
	public Melon() {
		super(); //�ݵ�� ���� �ʿ� x
		info = null;
	}
	
	public void setInfo(String info) { //������ 
		this.info = info;
	}
	
	public String getInfo() { //������
		return info;
	}
	
	public String toString() {
		String str = super.toString(); 
		/*
		 * �θ� Ŭ������ toString() ��ü�� �����
		 * Ŭ���� Food �� toString() �� �ʿ��� -> ��� ����
		 * Food�� toString() ��ü�� ����� ����.
		 */
		str += this.info;
		return str;
	}
}