package dto;

public class BookHistoryDto1 {
	private int id;
	private int isbn;
	private String name;
	private String email;
	private String lendday;
	private String scheduledday;
	private String returnday;
	
	public BookHistoryDto1(String name, int isbn, int id, String email, String lendday, String scheduledday,
			String returnday) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.email = email;
		this.lendday = lendday;
		this.scheduledday = scheduledday;
		this.returnday = returnday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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

	public String getLendday() {
		return lendday;
	}

	public void setLendday(String lendday) {
		this.lendday = lendday;
	}

	public String getScheduledday() {
		return scheduledday;
	}

	public void setScheduledday(String scheduledday) {
		this.scheduledday = scheduledday;
	}

	public String getReturnday() {
		return returnday;
	}

	public void setReturnday(String returnday) {
		this.returnday = returnday;
	}
}