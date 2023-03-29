
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

import dto.Account;
import dto.Account2;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AccountDAO {

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
	
	public static List<Account> All() {
		
		// 返却用変数
		List<Account> result = new ArrayList<>();

		String sql = "SELECT * FROM accountuser WEHRE situation = 1";
		
		try (
				Connection con =getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String mail = rs.getString("mail");
					String tell = rs.getString("tell");
					String password = rs.getString("password");
					String salt = rs.getString("salt");
					Account account = new Account(-1, id,name,tell, mail, 0 , password, salt);
					
					result.add(account);
				}
			}
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
	public static int registerAccount(Account account) {
		String sql = "INSERT INTO accountuser VALUES( default,?, ?, ?,0,?,?, current_timestamp)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(account.getPassword(), salt);
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(3, account.getMail());
			pstmt.setString(2,account.getTell());
			pstmt.setString(4, salt);
			pstmt.setString(5, hashedPw);
			pstmt.setString(1, account.getName());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM accountuser WHERE email = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
	public static Account login(String mail, String hashedPw) {
		String sql = "SELECT * FROM accountuser WHERE email = ? AND pw = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int situation = rs.getInt("situation");
					int id = rs.getInt("id");
					String tell = rs.getString("tel");
					String name = rs.getString("name");
					String salt = rs.getString("salt");
					
					return new Account(id,name,tell,mail, salt,situation,null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int situation(Account2 user) {
		String sql = "SELECT situation FROM accountuser WHERE email = ?";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, user.getMail());
		}catch(SQLException | URISyntaxException e) {
			e.printStackTrace();
		}finally{
			System.out.println("更新しました。");
		}
		return 0; 
	}
}