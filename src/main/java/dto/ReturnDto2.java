package dto;

public class ReturnDto2 {
	private int book_id;
	private String returnday;
	
	public ReturnDto2(int book_id, String returnday) {
		super();
		this.book_id = book_id;
		this.returnday = returnday;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getReturnday() {
		return returnday;
	}

	public void setReturnday(String returnday) {
		this.returnday = returnday;
	}
}