package dto;

public class BookDto3 {
	private int id;
	private int account_id;
	private int book_id;
	private String lendday;
	private String scheduledday;
	private String returnday;
	
	public BookDto3(int id, int account_id, int book_id, String lendday, String scheduledday, String returnday) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.book_id = book_id;
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