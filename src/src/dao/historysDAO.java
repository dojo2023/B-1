package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.History;

public class historysDAO {
	public  List<History>he(String userid) {
		Connection conn = null;
		List<History> sh = new ArrayList<History>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SELECT文を準備する
			String sql = "select s_history from historys where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userid);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs= pStmt.executeQuery();
			while (rs.next()) {
				History his = new History(
				rs.getString("s_history")
				);
				sh.add(his);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			sh= null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			sh= null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
						sh= null;
				}
			}

		}
		return sh;
	}
}
