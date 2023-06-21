package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pointsDAO {

	public int select(String userid) {
		Connection conn = null;

		int points;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select sum (point_pm) from points where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("dao29");

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("dao33");

		// 結果表をコレクションにコピーする
		rs.next();
		points = rs.getInt("sum(point_pm)");
		System.out.println("dao38");
	}
	catch (SQLException e) {
		e.printStackTrace();
		points = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		points = 0;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				points = 0;
			}
		}
	}
	System.out.println("dao60");
	// 結果を返す
	return points;
}
}