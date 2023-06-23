package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class itemspicsDAO {

	// dressServletのアイテム画像取得
	public String ipic(String userid) {
		Connection conn = null;

		String itempic;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select item_pic from itempics where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);
			System.out.println("dao30");

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao34");

			// 結果表をコレクションにコピーする
			rs.next();
			itempic = rs.getString("item_pic");
		}
		catch (SQLException e) {
			e.printStackTrace();
			itempic = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			itempic = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					itempic = null;
				}
			}
		}
		System.out.println("dao60");
	// 結果を返す
	return itempic;
	}

	// dressServletのアイテムポイント数取得
		public int iprice(String userid) {
			Connection conn = null;

			int itemprice;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

				// SQL文を準備する
				String sql = "select item_pic from itempics where user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
				pStmt.setString(1, userid);
				System.out.println("dao84");

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				System.out.println("dao88");

				// 結果表をコレクションにコピーする
				rs.next();
				itemprice = rs.getInt("item_pic");
			}
			catch (SQLException e) {
				e.printStackTrace();
				itemprice = 0;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				itemprice = 0;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemprice = 0;
					}
				}
			}
			System.out.println("dao114");
		// 結果を返す
		return itemprice;
		}
}
