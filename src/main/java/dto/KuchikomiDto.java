package dto;

public class KuchikomiDto {
	private int id;
	private String hyouka;
	
	public KuchikomiDto(int id, String hyouka) {
		super();
		this.id = id;
		this.hyouka = hyouka;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHyouka() {
		return hyouka;
	}

	public void setHyouka(String hyouka) {
		this.hyouka = hyouka;
	}
}
