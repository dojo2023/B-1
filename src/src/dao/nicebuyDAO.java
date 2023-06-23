package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Nicebuy;

public class nicebuyDAO {

	//nice buy押下された時の処理！
		// 戻り値としてboolean型のtrue or falseを利用
		public boolean insert(Nicebuy param) {
			// 変数宣言
			Connection conn = null;

			// 変数「result」の宣言、falseの代入
			boolean result = false;

			try {
			// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

			// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
				// シンプルにINSERTのSQL文記述してるだけ。
				// ？には↓記述の「setString」が入るよ。
				String sql = "insert into nicebuycounts (buyte_id, buyte_count) VALUES (?, +1); ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getBuyte_id() != null && !param.getBuyte_id().equals("")) {
					pStmt.setString(1, param.getBuyte_id());
				}
				else {
					pStmt.setString(1, null);
				}

				// SQL文を実行し、結果表を取得する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
	System.out.println("dao50さん");

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
