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
			System.out.println("dao29");

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao33");

			// 結果表をコレクションにコピーする
			rs.next();
			gchokin = rs.getInt("g_goal");
		} catch (SQLException e) {
			e.printStackTrace();
			gchokin = 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			gchokin = 0;
			System.out.println("dao43");
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
		System.out.println("dao55");
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
			System.out.println("だお80");
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("だお8３");

			// 結果表をコレクションにコピーする
			rs.next();
			glimit = rs.getString("g_limit");
			System.out.println("だお8７");

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
		System.out.println("だお１０６");

		// 結果を返す
		return glimit;
	}
public String getavailable(String userid) {
	Connection conn = null;

	String gavailable;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select g_available from goals where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("だお80");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("だお8３");

		// 結果表をコレクションにコピーする
		rs.next();
		gavailable = rs.getString("g_available");
		System.out.println("だお8７");

	} catch (SQLException e) {
		e.printStackTrace();
		gavailable = null;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		gavailable = null;
	} finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				gavailable = null;
			}
		}
	}
	System.out.println("だお１０６");

	// 結果を返す
	return gavailable;
}
//欲しいもの名を出力
	public String getwant(String userid) {
		Connection conn = null;

		String gwant;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select g_want from goals where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);
			System.out.println("だお181");
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("だお184");

			// 結果表をコレクションにコピーする
			rs.next();
			gwant = rs.getString("g_want");
			System.out.println("だお189");

		} catch (SQLException e) {
			e.printStackTrace();
			gwant = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			gwant = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					gwant = null;
				}
			}
		}
		System.out.println("だお208");

		// 結果を返す
		return gwant;
}
	//目標期間を出力
		public int calendarlimit(String userid) {
			Connection conn = null;

			int glimit;

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
				System.out.println("だお80");
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				System.out.println("だお8３");

				// 結果表をコレクションにコピーする
				rs.next();
				glimit = rs.getInt("g_limit");
				System.out.println("だお8７");

			} catch (SQLException e) {
				e.printStackTrace();
				glimit = 0;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				glimit = 0;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						glimit = 0;
					}
				}
			}
			System.out.println("だお１０６");

			// 結果を返す
			return glimit;
}
}