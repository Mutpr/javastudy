package src2_20200810;

public class Book {
	private String title;
	private int page;
	private String author;
	
	public Book(String ti, int pa, String aut) {
		title = ti;
		page = pa;
		author = aut;
	}
	
	
	public void BookInfo() {
		System.out.println("����: "+title);
		System.out.println("������ ��:"+page);
		System.out.println("����: "+author);
	}
}