package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class goalsDAO {

	public int select(String userid) {
		Connection conn = null;

		int gchokin;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select g_goal from goals where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			gchokin = rs.getInt("g_gaol");
		} catch (SQLException e) {
			e.printStackTrace();
			gchokin = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			gchokin = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					gchokin = 0;
				}
			}
		}

		// 結果を返す
		return gchokin;
	}

	//目標期間を出力
	public String getlimit(String userid) {
		Connection conn = null;

		String glimit;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select g_limit from goals where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			glimit = rs.getString("g_limit");
		} catch (SQLException e) {
			e.printStackTrace();
			glimit = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			glimit = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					glimit = null;
				}
			}
		}

		// 結果を返す
		return glimit;
	}
}