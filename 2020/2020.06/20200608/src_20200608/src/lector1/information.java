package lector1;

public class information {
	String id;
	int pass;
	
	public information() {
		this("",0);
	}
	
	public information(String id, int pass) {
		this.id = id;
		this.pass = pass;
	}
	
	public information(String id) {
		this(id, (int)Math.random()*9000+1000);
	}
	
	public String toString() {
		return "information [id = "+id+" ,pass=" + pass +"]";
	}
	
	void setPass(int pass) {
		this.pass=pass;
	}
}