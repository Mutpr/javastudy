package kr.co.infopub.chapter.s082;
import java.io.Serializable;
public class Billboard implements Serializable { //serializable ����ȭ ����(���߿� ������)
	private int rank;
	private String song;
	private int lastWeek;
	private String imagesrc;
	private String artistsrc;
	private String artist;
	
	public Billboard() { }
	
	public Billboard(int rank, String song, int lastWeek, String imagesrc,
			String artistsrc, String artist) {
		super();
		this.rank = rank;
		this.song = song;
		this.lastWeek = lastWeek;
		this.imagesrc = imagesrc;
		this.artistsrc = artistsrc;
		this.artist = artist;
	}
	
	public Billboard(int rank, String song, int lastWeek, String imagesrc, String artist) {
		super();
		this.rank = rank;
		this.song = song;
		this.lastWeek = lastWeek;
		this.imagesrc = imagesrc;
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return "[rank ="+rank+" ,song"+song+" ,lastWeek="+lastWeek+
				" ,imagesrc="+imagesrc+" ,artist="+artist+
				"]";
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
		
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public int getLastWeek() {
		return lastWeek;
	}
	
	public void setLastWeek(int lastWeek) {
		this.lastWeek = lastWeek;
	}
	
	public String getImagesrc() {
		return imagesrc;
	}
	
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
	
	public String getArtistsrc() {
		return artistsrc;
	}
	
	public void setArtistsrc(String artistsrc) {
		this.artistsrc = artistsrc;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
