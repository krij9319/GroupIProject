package dto;

public class BookDto3 {
	private int id;
	private int isbn;
	private String name;
	private String register_day;
	private String booksitu;
	
	public BookDto3(int id, int isbn, String name, String register_day, String booksitu) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.register_day = register_day;
		this.booksitu = booksitu;
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

	public String getRegister_day() {
		return register_day;
	}

	public void setRegister_day(String register_day) {
		this.register_day = register_day;
	}

	public String getBooksitu() {
		return booksitu;
	}

	public void setBooksitu(String booksitu) {
		this.booksitu = booksitu;
	}
}