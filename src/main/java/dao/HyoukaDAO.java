package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.KuchikomiDto1;
public class HyoukaDAO {

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
	public static int registerKuchikomiDto1(KuchikomiDto1 hyouka) {
		String sql = "INSERT INTO hyouka VALUES(default,?,current_timestamp)";

		// return用の変数
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){

			pstmt.setString(1, hyouka.getKuchikomi());

	
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static List<KuchikomiDto1> selectAllhyouka() {

		String sql = "SELECT * FROM hyouka ORDER BY id ASC";

		List<KuchikomiDto1> result = new ArrayList<>();
		
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Integer id = rs.getInt("id");

					String kuchikomi = rs.getString("kuchikomi");

					KuchikomiDto1 hyouka = new KuchikomiDto1(id,kuchikomi);
					
					result.add(hyouka);
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