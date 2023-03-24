package dto;
public class BookDto1 {
	private int id;
	private int isbn;
	private String name;
	private String auther;
	private String publisher;
	private String examDate;
	
	public BookDto1(int id, int isbn, String name, String auther, String publisher, String examDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.auther = auther;
		this.publisher = publisher;
		this.examDate = examDate;
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

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

}
