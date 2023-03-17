package dto;

public class Account{
	private int id;
	private String name;
	private String email;
	private String salt;
	private String pw;
	private String hashedPassword;
	private String tel;
	
	public Account(int id, String name, String email, String salt, String pw, String hashedPassword, 
			 String tel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salt = salt;
		this.pw = pw;
		this.hashedPassword = hashedPassword;
		this.tel = tel;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	
}
