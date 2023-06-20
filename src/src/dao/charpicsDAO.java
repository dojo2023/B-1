package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class charpicsDAO {
	//キャラ画像
	public String pic(String userid) {
		Connection conn = null;
		int health;
		String picture;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		String sql = "select sum(health_pm) from healths where user_id =?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(String userid)をSQLに入れる)
		pStmt.setString(1, userid);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		health = rs.getInt("health_pm");

		// SQL文を準備する
		String sql2 = "select char_pic, c_health from characters as c  join charpics as p on c.char_id = p.char_id where c.user_id = ? and c_health = ?";
		PreparedStatement pStmt2 = conn.prepareStatement(sql2);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt2.setString(1, userid);

		pStmt2.setInt(2,health);

		// SQL文を実行し、結果表を取得する
		ResultSet rs2 = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		picture= rs2.getString("char_pic");
	}
	catch (SQLException e) {
		e.printStackTrace();
		picture = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		picture = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				picture = null;
			}
		}
	}

	// 結果を返す
	return picture;
	}

}
