package src1_20200803;

public class Melon extends Food {
	String farm;
	
	public void setFarm(String farm) {
		this.farm = farm;
	}
	
	public String getFarm() {
		return farm;
	}
	
	public String toString() {
		return "[ cost="+cost+"\t kg = "+weight+"\t ���۳��="+farm+" ]";
	}
}