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

import dto.BookDto1;
import dto.BookDto2;
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
		String sql = "INSERT INTO book VALUES(DEFAULT,?,?,?,?,current_timestamp)";
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
	
	public static List<BookDto1> search(String name){
		String sql = "SELECT * FROM book WHERE name LIKE ?";
		List<BookDto1> result = new ArrayList<>();
		
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
					
					BookDto1 book = new BookDto1(-1,isbn,name,auther,publisher);
					
					result.add(book);
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int update(BookDto1 book) {
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
		Date days = new Date();
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book2.getBook_id());
			
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()){
					Date day = rs.getDate("register_day");
					
					return days;
				}
			}
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null ;
	}
}