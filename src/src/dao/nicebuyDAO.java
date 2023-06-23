package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Nicebuy;

public class nicebuyDAO {

	//まずは画面遷移された時の処理！
		// 最新投稿順でデータ持ってくるメソッド
		// 戻り値としてArrayList<buytters>型の変数を利用
		public List<Nicebuy> select() {
			// 変数宣言
			Connection conn = null;

			// return用オブジェクトの生成
			List<Nicebuy> nicebuyList = new ArrayList<Nicebuy>();

			try {
			// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

			// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
				// シンプルにINSERTのSQL文記述してるだけ。
				// ？には↓記述の「setString」が入るよ。
				String sql = "insert into nicebuycounts (user_id, b_comment, b_pic) VALUES (?, ?, ?); ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
				// コレクションは可変長配列のやつの事だよ。
				while (rs.next()) {
					Nicebuy card = new Nicebuy(
					rs.getString("buyte_id"),
					rs.getString("buyte_count")
					);
					nicebuyList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				nicebuyList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				nicebuyList = null;
			}
			finally {

			// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						nicebuyList = null;
					}
				}
			}

			// 結果を返す
				// 結果とはさっき作った可変長配列の結果表の事だよ。
				return nicebuyList;
		}



}
