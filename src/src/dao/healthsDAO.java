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
	//roomServeltでのキャラ状態
			public int gethealthpm(String userid) {
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
			//目標達成画面で今までの健康をすべて削除。成功したらtrueを返す
			public boolean delete(String userid) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/MYBC", "sa", "");

					// SQL文を準備する
					String sql = "delete from healths where user_id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, userid);

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
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

				// 結果を返す
				return result;
			}
		}

