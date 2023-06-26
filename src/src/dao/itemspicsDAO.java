package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DressUp;

public class itemspicsDAO {
	// pictureBookServletに図鑑のキャラ画像取得
	public List<DressUp> select(String userid) {
		// 変数宣言
		Connection conn = null;

		List<DressUp> iplist = new ArrayList<DressUp>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select item_pic from itempics as p join items as i on p.item_id = i.item_id where i.user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao0037");

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				DressUp dcard = new DressUp(
						rs.getString("item_pic"));
				iplist.add(dcard);
				System.out.println(rs.getString("item_pic"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			iplist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			iplist = null;
		} finally {

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					iplist = null;
				}
			}
		}

		// 結果を返す
		// 結果とはさっき作った可変長配列の結果表の事だよ。
		return iplist;
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
				String sql = "select  from itempics where user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
				pStmt.setString(1, userid);
				System.out.println("dao84");

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				System.out.println("dao88");

				// 結果表をコレクションにコピーする
				rs.next();
				itemprice = rs.getInt("");
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

		// dressServletのitem_buyって何？
				public int ibuy(String userid) {
					Connection conn = null;

					int itembuy;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

						// SQL文を準備する
						String sql = "select item_buy from itempics where user_id=?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
						pStmt.setString(1, userid);
						System.out.println("dao84");

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						System.out.println("dao88");

						// 結果表をコレクションにコピーする
						rs.next();
						itembuy = rs.getInt("item_buy");
					}
					catch (SQLException e) {
						e.printStackTrace();
						itembuy = 0;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						itembuy = 0;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								itembuy = 0;
							}
						}
					}
					System.out.println("dao114");
				// 結果を返す
				return itembuy;
				}
}
