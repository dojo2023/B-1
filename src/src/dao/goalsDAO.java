package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.SetGoals;

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



//キャラ名
public String getcname(String userid) {
	Connection conn = null;

	String cname ;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select c_name from goals where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("だお80");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("だお8３");

		// 結果表をコレクションにコピーする
		rs.next();
		cname = rs.getString("c_name");
		System.out.println("だお8７");

	} catch (SQLException e) {
		e.printStackTrace();
		cname = null;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		cname = null;
	} finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				cname = null;
			}
		}
	}
	System.out.println("だお１０６");

	// 結果を返す
	return cname;
}
//出会って何日
public Timestamp getupdateat(String userid) {
	Connection conn = null;

	Timestamp time ;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select created_at from goals where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("だお80");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("だお8３");

		// 結果表をコレクションにコピーする
		rs.next();
		time = rs.getTimestamp("created_at");
		System.out.println("だお8７");

	} catch (SQLException e) {
		e.printStackTrace();
		time = null;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		time = null;
	} finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				time = null;
			}
		}
	}
	System.out.println("だお１０６");

	// 結果を返す
	return time;
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

		//目標設定画面から格納
		public boolean setGoal(SetGoals goals) {
			Connection conn = null;
			boolean hanbetu = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");


				// SQL文を準備する
				String sql = "insert into goals(g_goal,g_limit,g_want,c_name,user_id,g_available) values (?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				System.out.println("77");
				// SQL文を完成させる
				if (goals.getGgoals() != 0) {
					pStmt.setInt(1, goals.getGgoals());
					System.out.println("82");
				}

				else {
					pStmt.setInt(1, 0);
					System.out.println("87");
				}

				if (goals.getGlimit() != null){
					pStmt.setString(2, goals.getGlimit());
					System.out.println("92");
				}
				else {
					pStmt.setString(2, "");
					System.out.println("96");
				}
				if (goals.getGwant() != null) {
					pStmt.setString(3, goals.getGwant());
					System.out.println("100");
				}
				else {
					pStmt.setString(3, "");
					System.out.println("105");

				}
				if (goals.getCname() != null) {
					pStmt.setString(4, goals.getCname());
					System.out.println("100");
				}
				else {
					pStmt.setString(4, "");
					System.out.println("105");

				}
				if (goals.getUserid() != null) {
					pStmt.setString(5, goals.getUserid());
					System.out.println("100");
				}
				else {
					pStmt.setString(5, "");
					System.out.println("105");

				}
				if (goals.getGavailable() != 0) {
					pStmt.setInt(6, goals.getGavailable());
					System.out.println("100");
				}
				else {
					pStmt.setInt(6,0);
					System.out.println("105");

				}
				System.out.println("109");

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					hanbetu = true;
					System.out.println("114");

				}
				System.out.println("117");

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
			return hanbetu;
		}
		//目標設定日を取得
		public Timestamp getCreate(String userid) {
			Connection conn = null;

			Timestamp create;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

				// SQL文を準備する
				String sql = "select created_at from goals where user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
				pStmt.setString(1, userid);
				System.out.println("dao29");

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				System.out.println("dao33");

				// 結果表をコレクションにコピーする
				rs.next();
				create = rs.getTimestamp("created_at");
			} catch (SQLException e) {
				e.printStackTrace();
				create = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				create = null;
				System.out.println("dao43");
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						create = null;
					}
				}
			}
			System.out.println("dao55");
			// 結果を返す
			return create;
		}
		//目標達成画面で今までの目標をすべて削除。成功したらtrueを返す
		public boolean delete(String userid) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

				// SQL文を準備する
				String sql = "delete from goals where user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				System.out.println("goaDAO：542");

				// SQL文を完成させる
				pStmt.setString(1, userid);
				System.out.println("goaDAO：546");

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
					System.out.println("goaDAO：551");

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
			System.out.println("goaDAO：572");

			// 結果を返す
			return result;
		}

}