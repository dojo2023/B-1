package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class healthsDAO {
	public int he(String userid) {
		Connection conn = null;
		int chealth = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SELECT文を準備する
			String sql = "select sum(health_pm) from healths where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userid);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs= pStmt.executeQuery();
			chealth = rs.getInt("health_pm");
		} catch (SQLException e) {
			e.printStackTrace();
			chealth = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			chealth = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					chealth = 0;
				}
			}

		}
		return chealth;
	}
}
