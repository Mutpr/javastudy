package src3_20200608;
/*
 * 필드 :제목, 저자, private
	메소드 :	생성자 : 매개변수로 받은 값을 필드값으로 초기화
	각 필드에 대한 getter, setter 메소드
	객체 내용을 문자열로 반환하는 toString() 메소드

 */
public class book {
	private String name;
	private String author;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return "저자:"+author+"\t제목:"+name;
	}
	
}