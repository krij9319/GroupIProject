package dto;

public class KuchikomiDto1 {
	private int id;
	private String kuchikomi;
	
	public KuchikomiDto1(int id, String kuchikomi) {
		super();
		this.id = id;
		this.kuchikomi = kuchikomi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKuchikomi() {
		return kuchikomi;
	}

	public void setKuchikomi(String kuchikomi) {
		this.kuchikomi = kuchikomi;
	}
}
