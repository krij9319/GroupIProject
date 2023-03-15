package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.BookDto1;

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
}
