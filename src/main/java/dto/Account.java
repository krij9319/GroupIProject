package dto;

public class Account{
	private int id;
	private String name;
	private String tell;
	private String mail;
	private String password;
	private int situation;
	private String salt;
	private String hashedPassword;
	
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

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public Account(int id, String name, String tell, String mail, String password, int situation, String salt,
			String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.tell = tell;
		this.mail = mail;
		this.password = password;
		this.situation = situation;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
	}
}