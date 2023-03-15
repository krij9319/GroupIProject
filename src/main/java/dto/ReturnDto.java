package dto;

public class ReturnDto {
	private int book_id;

	public ReturnDto(int book_id) {
		super();
		this.book_id = book_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
}
