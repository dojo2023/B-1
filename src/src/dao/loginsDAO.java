package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loginsDAO {
	public boolean insert(String userid) {
		Connection conn = null;
		boolean check = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");


			// SQL文を準備する
			String sql = "insert into logins(user_id,h_login) values (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println("dao88");

			// SQL文を完成させる
//			if (Payments.getPaycategory() != null && !Payments.getPaycategory() .equals("")) {
			pStmt.setString(1,userid);
			System.out.println("dao94");

//			}else{
//				pStmt.setString(1, "");
//			}

			pStmt.setInt(2,1);
			System.out.println("dao99");

			// SQL文を実行する
			if(pStmt.executeUpdate() == 1) {
				check = true;
				System.out.println("da106");
			}
			System.out.println("dao108");
		}
		catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			check = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					check = false;
				}
			}
		}

		// 結果を返す
		return check;
	}
	/*
	public int c_login(String userid,String day) {
		Connection conn = null;
		int con = 0;
		int log = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SELECT文を準備する
			while(con<30) {
				String sql = "select count(*) from logins where user_id = ? and created_at = ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, userid);
				if(con<10) {

					pStmt.setString(2,);
				}




			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				log ++ ;
			}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}*/
}
