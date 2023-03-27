package dto;
public class BookDto1 {
	private int id;
	private int isbn;
	private String name;
	private String auther;
	private String publisher;
	
	public BookDto1(int id, int isbn, String name, String auther, String publisher) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.auther = auther;
		this.publisher = publisher;
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
}