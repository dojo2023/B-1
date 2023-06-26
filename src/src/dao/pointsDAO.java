package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ranking;

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
	//ランキング用
	public List<Ranking> rankList() {
		Connection conn = null;
		List<Ranking> rankList = new ArrayList<Ranking>();
		int i = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select sum(point_pm),user_id from points group by user_id order by sum(point_pm) desc" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println("dao33");
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao36");
			// 結果表をコレクションにコピーする
			while (i<5 && rs.next()) {
				Ranking rank = new Ranking(
				rs.getString("user_id"),
				rs.getInt("sum(point_pm)")
				);
				rankList.add(rank);
				i++;
				System.out.println("dao96");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			rankList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			rankList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					rankList = null;
				}
			}
		}
		System.out.print("dao67");
		// 結果を返す
		return rankList;
	}

	//ログインポイント付与
	public boolean loginP(String userid) {
		Connection conn = null;

		boolean check = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "insert into payments(user_id,points_pm) values (?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("dao29");

		//point１５０にした。
		pStmt.setInt(2, 150);
		System.out.println("dao29");

		//できたか。どうか
		if(pStmt.executeUpdate() == 1) {
			check = true;
			System.out.println("da106");
		}
		System.out.println("dao33");

		// 結果表をコレクションにコピーする
		System.out.println("dao38");
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("dao60");
	// 結果を返す
	return check;
}
	//回復アイテム購入処理-300
	public boolean healP(String userid) {
		Connection conn = null;

		boolean check = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "insert into points(user_id,point_pm) values (?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("dao29");

		//point１５０にした。
		pStmt.setInt(2, -300);
		System.out.println("dao29");

		//できたか。どうか
		if(pStmt.executeUpdate() == 1) {
			check = true;
			System.out.println("da106");
		}
		System.out.println("dao33");

		// 結果表をコレクションにコピーする
		System.out.println("dao38");
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("dao60");
	// 結果を返す
	return check;
}
}