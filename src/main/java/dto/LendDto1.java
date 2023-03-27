package dto;

public class LendDto1 {
	private int id;
	private int account_id;
	private int book_id;
	
	public LendDto1(int id, int account_id, int book_id) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.book_id = book_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
}