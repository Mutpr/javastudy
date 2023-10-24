package src2;

class Magazine extends Book { //food ����ϴ� melon Ŭ���� �ۼ�
	private String info; //���� ��� ����
	
	public Magazine(String name, String page, String author, String info) { //������ �Ű�����
		//���ݰ� �߷� ���� �� �޾� ��
		//�θ� Ŭ������ �Ű����� ���� �޾ƿͼ� �ʿ��� �� ����
		super(name,page,author); //Food �� ������ ȣ��
		this.info = info; 
	}
	
	public Magazine() {
		//super(); //�ݵ�� ���� �ʿ� x
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