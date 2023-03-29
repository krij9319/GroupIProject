package dto;

public class Account2 {
	private int situation;
	private String mail;
	
	public Account2(int situation, String mail) {
		super();
		this.situation = situation;
		this.mail = mail;
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}