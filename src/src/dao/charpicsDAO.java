package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class charpicsDAO {
	//ヘルス取得
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

		System.out.println("charpicDAO:25");
		// SQL文を完成させる(servletから取得したuserid(String userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("charpicDAO:298");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("charpicDAO:31");
		// 結果表をコレクションにコピーする
		rs.next();
		health = rs.getInt("sum(health_pm)");
		System.out.println("charpicDAO:35");
	}
	catch (SQLException e) {
		e.printStackTrace();
		health = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		health = 0;

	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				health = 0;

			}
		}
	}
	System.out.println("charpicDAO:59");
	// 結果を返す
	return health;
	}
//healthをもとに画像取得
	public String pic(int health,String userid) {
		Connection conn = null;
		String picture;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");
		// SQL文を準備する
		String sql2 = "select char_pic, c_health from characters as c  join charpics as p on c.char_id = p.char_id where c.user_id = ? and c_health = ? ORDER BY c.id DESC";
		PreparedStatement pStmt2 = conn.prepareStatement(sql2);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt2.setString(1, userid);

		pStmt2.setInt(2,health);

		// SQL文を実行し、結果表を取得する
		ResultSet rs2 = pStmt2.executeQuery();

		// 結果表をコレクションにコピーする
		rs2.next();
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

	// 背景画像とキャラクター画像(calendar)
	public String charpic(String userid) {
		Connection conn = null;

		String charpic;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select char_pic from charpics where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);
			System.out.println("だお93");
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("だお96");

			// 結果表をコレクションにコピーする
			rs.next();
			charpic = rs.getString("char_pic");
			System.out.println("だお１０１");

		} catch (SQLException e) {
			e.printStackTrace();
			charpic = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			charpic = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					charpic = null;
				}
			}
		}
		System.out.println("だお１２０");

		// 結果を返す
		return charpic;
	}
}
