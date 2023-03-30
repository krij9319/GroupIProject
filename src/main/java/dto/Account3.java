package dto;

public class Account3 {
	private int id;
	private String name;

	private String mail;
	
	public Account3(int id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;

	private String email;
	
	public Account3(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}