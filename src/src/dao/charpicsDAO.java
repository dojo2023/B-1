package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class charpicsDAO {
	//キャラ画像
	public int health(String userid) {
		Connection conn = null;
		int health;

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
			System.out.println("dao31");
			// 結果表をコレクションにコピーする
			rs.next();
			health = rs.getInt("sum(health_pm)");
			System.out.println("dao34");
			System.out.println(health);
		} catch (SQLException e) {
			e.printStackTrace();
			health = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			health = 0;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					health = 0;
				}
			}
		}

		// 結果を返す
		return health;
	}
//上のメソッドとUSERIDいれたら写真が出るよ

	public String pic(int health,String userid) {

		Connection conn = null;
		String picture = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql= "select char_pic from characters as c  join charpics as p on c.char_id = p.char_id where c.user_id = ? and c_health = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			pStmt.setInt(2, health);
			System.out.println("dao45");

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao49");

			// 結果表をコレクションにコピーする
			rs.next();
			picture = rs.getString("char_pic");
			System.out.println("dao53");
			System.out.println(picture);

		} catch (SQLException e) {
			e.printStackTrace();
			picture = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			picture = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					picture = null;
				}
			}
		}

		// 結果を返す
		return picture;
	}

}
