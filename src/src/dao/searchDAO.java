package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Search;

public class searchDAO {
//まずは画面遷移された時の処理！
	// 最新投稿順でデータ持ってくるメソッド
	// 戻り値としてArrayList<buytters>型の変数を利用
	public List<Search> select(Search param) {
		// 変数宣言
		Connection conn = null;
		// return用オブジェクトの生成
		List<Search> searchHistoryList = new ArrayList<Search>();
		int i = 0;

		try {
		// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

		// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
			// シンプルにSELECTのSQL文記述してるだけ。
			// ？には↓記述の「setString」が入るよ。
			// ↓この文の最後に「order by id desc」って書いてて、
			// これが「idの降順」って意味だよ。
//			String sql = "select id, user_id, b_comment, b_pic, created_at from buytters order by id desc";
			String sql = "select s_history from historys where user_id = ? order by id desc offset 0 rows fetch next 5 rows only;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, param.getUser_id());

		// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
			// コレクションは可変長配列のやつの事だよ。
			while (rs.next()) {
				Search card = new Search(
				rs.getString("s_history"),i
				);
				System.out.println("1s_historyさん"+rs.getString("s_history"));
				searchHistoryList.add(card);
				System.out.println("cardさん"+card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			searchHistoryList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			searchHistoryList = null;
		}
		finally {

		// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					searchHistoryList = null;
				}
			}
		}

		// 結果を返す
			// 結果とはさっき作った可変長配列の結果表の事だよ。
			return searchHistoryList;
	}


// 次は投稿の処理！
		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Search param) {
			Connection conn = null;
	System.out.println("dao87さん");

//			// 変数「result」の宣言、falseの代入
			boolean result = false;

	System.out.println("dao92さん");

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1","sa","");

				// SQL文を準備する
				String sql = "insert into historys (user_id, s_history) VALUES (?, ?); ";
				PreparedStatement pStmt = conn.prepareStatement(sql);
	System.out.println("dao104さん");

				// SQL文を完成させる
				if (param.getUser_id() != null && !param.getUser_id().equals("")) {
					pStmt.setString(1, param.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (param.getB_comment() != null && !param.getB_comment().equals("")) {
					pStmt.setString(2, param.getB_comment());
				}
				else {
					pStmt.setString(2, "");
				}
	System.out.println("dao125さん");

				// SQL文を実行し、結果表を取得する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
	System.out.println("dao131さん");

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
			// 結果とはさっき作った可変長配列の結果表の事だよ。
			return result;
	}
}