package src2;

public class Book {
	private String name;
	private String page;
	private String author;
	
	public Book(String name, String page, String author) {
		//�ʱ�ȭ ������ �Ű����� 
		this.name = name;
		this.page = page;
		this.author = author;
		//�ʵ�� �ʱ�ȭ
	}

	public Book() {
		//default ������ 
		this(null, null, null); //�߷��� ���� ���� 0���� �ʱ�ȭ 
		//���� Ŭ�������� �����ε� �� �����ڸ� �ʱ�ȭ
	}
	
	//������ �޼ҵ� : setter �޼ҵ�
	public void setName(String name) {
		this.name = name;
	}
	//������ �޼ҵ�: getter �޼ҵ�
	public String getName() {
		return name;
	}
	
	public void setPage(String page) {
		this.page = page;
	}
	
	//������ �޼ҵ�: getter �޼ҵ�
	public String getPage() {
		return name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	//������ �޼ҵ�: getter �޼ҵ�
	public String getAuthor() {
		return author;
	}
	
	
	@Override
	public String toString() {
		return "å �̸�: "+ name+"\n ������ ��: "+page+"\n �۰�: "+author+"\n ";
		//cost �� kg�� ���ݰ� �߷�?
	}
}