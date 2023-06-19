package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class banksDAO {

	public int select(String userid) {
		Connection conn = null;

		int chokin;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select sum (b_bank) from banks where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1, userid);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		chokin = rs.getInt("b_bank");
	}
	catch (SQLException e) {
		e.printStackTrace();
		chokin = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		chokin = 0;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				chokin = 0;
			}
		}
	}

	// 結果を返す
	return chokin;
}
}