package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.Account3;
import dto.BookDto1;
import dto.BookDto2;
import dto.BookDto3;
import dto.BookDto4;
import dto.BookDto5;
import dto.BookHistoryDto1;
import dto.LendDto1;
import dto.LendDto2;
import dto.ReturnDto;
import dto.ReturnDto2;

public class Dao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int register(BookDto1 book) {
		String sql = "INSERT INTO book VALUES(DEFAULT,?,?,?,?,'貸出可能',NOW())";
		int result = 0;
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getIsbn());
			pstmt.setString(2, book.getName());
			pstmt.setString(3, book.getAuther());
			pstmt.setString(4, book.getPublisher());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int delete(BookDto2 book) {
		String sql = "DELETE FROM book WHERE id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getId());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static List<BookDto4> search(String name){
		String sql = "SELECT * FROM book WHERE name LIKE ?";
		List<BookDto4> result = new ArrayList<>();
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, "%" + name + "%");
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int isbn = rs.getInt("isbn");
					String auther = rs.getString("auther");
					String publisher = rs.getString("publisher");
					
					BookDto4 book = new BookDto4(-1,isbn,name,auther,publisher);
					
					result.add(book);
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int update(BookDto4 book) {
		String sql = "UPDATE book SET isbn = ?,name = ?,auther = ?,publisher = ? WHERE id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getIsbn());
			pstmt.setString(2, book.getName());
			pstmt.setString(3, book.getAuther());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getId());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int returnbook(ReturnDto book) {
		String sql = "DELETE FROM book_lend WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int returnday(ReturnDto2 day) {
		String sql = "UPDATE book_lend SET returnday = NOW() WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, day.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int lendday(LendDto1 book1) {
		String sql = "INSERT INTO book_lend VALUES(DEFAULT,?,?,NOW())";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book1.getAccount_id());
			pstmt.setInt(2, book1.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int lend7(LendDto2 book2) {
		String sql = "UPDATE book_lend SET scheduledday = lendday + cast('7 days' as INTERVAL) WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int lend14(LendDto2 book2) {
		String sql = "UPDATE book_lend SET scheduledday = lendday + cast('14 days' as INTERVAL) WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static Date date(LendDto2 book2) {
		String sql = "SELECT register_day FROM book,book_lend WHERE book.id = book_lend.book_id AND book_id = ?";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					Date day = rs.getDate("register_day");
					
					return day;
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public static int bookhisttory(LendDto1 book1) {
		String sql = "INSERT INTO book_history VALUES(DEFAULT,?,?,NOW())";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book1.getAccount_id());
			pstmt.setInt(2, book1.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int lend7_2(LendDto2 book2) {
		String sql = "UPDATE book_history SET scheduledday = lendday + cast('7 days' as INTERVAL) WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int lend14_2(LendDto2 book2) {
		String sql = "UPDATE book_history SET scheduledday = lendday + cast('14 days' as INTERVAL) WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}

	public static int returnhistory(ReturnDto2 book3) {
		String sql = "UPDATE book_history SET returnday = NOW() WHERE book_id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book3.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static Date date2(LendDto2 book2) {
		String sql = "SELECT date2 FROM deadline WHERE id = ?";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					Date day = rs.getDate("date2");
					
					return day;
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public static int deadline() {
		String sql = "INSERT INTO deadline VALUES(DEFAULT,NOW())";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました");
		}
		return result;
	}
	
	public static int deadline2(LendDto2 book3) {
		String sql = "UPDATE deadline SET date2 = date1 + cast('1 years' as INTERVAL) WHERE id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book3.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static List<BookDto3> all(){
		List<BookDto3> result = new ArrayList<>();
		
		String sql = "SELECT id,isbn,name,register_day,booksitu FROM book ORDER BY id ASC";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					int isbn = rs.getInt("isbn");
					String name = rs.getString("name");
					String register_day = rs.getString("register_day");
					String booksitu = rs.getString("booksitu");
					
					BookDto3 book = new BookDto3(id,isbn,name,register_day,booksitu);
					result.add(book);
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<BookHistoryDto1> history() {
		String sql = "select email,book.id,isbn,book.name,lendday,scheduledday,returnday from accountuser,book,book_history where accountuser.id = book_history.book_id and book.id = book_history.book_id";
		List<BookHistoryDto1> result = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String email = rs.getString("email");
					int id = rs.getInt("id");
					int isbn = rs.getInt("isbn");
					String name = rs.getString("name");
					String lendday = rs.getString("lendday");
					String scheduledday = rs.getString("scheduledday");
					String returnday = rs.getString("returnday");
					
					BookHistoryDto1 book = new BookHistoryDto1(email,id,isbn,name,lendday,scheduledday,returnday);
					
					result.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e1) {
			e1.printStackTrace();
		} 

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
	public static List<BookDto5> history2() {
		String sql = "select id,account_id,book_id,lendday,scheduledday,returnday from book_history";
		List<BookDto5> result = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					int account_id = rs.getInt("account_id");
					int book_id = rs.getInt("book_id");
					String lendday = rs.getString("lendday");
					String scheduledday = rs.getString("scheduledday");
					String returnday = rs.getString("returnday");
					
					BookDto5 book = new BookDto5(id,account_id,book_id,lendday,scheduledday,returnday);
					
					result.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e1) {
			e1.printStackTrace();
		} 

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
	public static int booksitu(LendDto2 book2) {
		String sql = "UPDATE book SET booksitu = '貸出中' WHERE id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static int booksitu2(ReturnDto book2) {
		String sql = "UPDATE book SET booksitu = '貸出可能' WHERE id = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			result = pstmt.executeUpdate();
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static List<Account3> accountuser() {
		String sql = "SELECT id,name,email FROM accountuser";
		List<Account3> result = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					
					Account3 account = new Account3(id,name,email);
					
					result.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e1) {
			e1.printStackTrace();
		} 

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
}