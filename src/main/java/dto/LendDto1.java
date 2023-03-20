package dto;

public class LendDto {
	private int id;
	private String email;
	private int book_id;
	
	public LendDto(int id, String email, int book_id) {
		super();
		this.id = id;
		this.email = email;
		this.book_id = book_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
}
