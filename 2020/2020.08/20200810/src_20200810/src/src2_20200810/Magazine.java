package src2_20200810;

public class Magazine extends Book{
	private String release;
	
	public Magazine(String ti, int pa, String aut, String re) {
		super(ti, pa, aut);
		release = re;
	}
	
	public void BookInfo() {
		super.BookInfo();
		System.out.println("�߸���: "+release);
	}
}