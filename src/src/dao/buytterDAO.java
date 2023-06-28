package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Buytters;

public class buytterDAO {
//まずは画面遷移された時の処理！
	// 最新投稿順でデータ持ってくるメソッド
	// 戻り値としてArrayList<buytters>型の変数を利用
	public List<Buytters> select() {
		// 変数宣言
		Connection conn = null;

		// return用オブジェクトの生成
		List<Buytters> buyeetList = new ArrayList<Buytters>();

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
			String sql = "select buytters.id, user_id, b_comment, b_pic, buytters.created_at, buyte_sum from buytters, (select buyte_id, sum(buyte_count) as buyte_sum from nicebuycounts group by buyte_id)nicebuycounts where id = buyte_id order by id desc;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//ユーザー名取得
			idpwsDAO idao = new idpwsDAO();
		// 結果表をコレクションにコピーする
			// コレクションは可変長配列のやつの事だよ。
			while (rs.next()) {
				String user_name =idao.getName(rs.getString("user_id"));
				Buytters card = new Buytters(
				rs.getString("id"),
				user_name,
				rs.getString("b_comment"),
				rs.getString("b_pic"),
				rs.getString("created_at"),
				rs.getString("buyte_sum")
				);
				buyeetList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			buyeetList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			buyeetList = null;
		}
		finally {

		// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					buyeetList = null;
				}
			}
		}

		// 結果を返す
			// 結果とはさっき作った可変長配列の結果表の事だよ。
			return buyeetList;
	}


// 次は投稿の処理！
		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Buytters param) {
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
				String sql = "insert into buytters (user_id, b_comment, b_pic) VALUES (?, ?, ?); "
						+ "insert into nicebuycounts(buyte_id, created_at, buyte_count) select buytters.id, buytters.created_at, 0 from buytters order by id desc fetch next 1 rows only;";
				PreparedStatement pStmt = conn.prepareStatement(sql);
//				PreparedStatement pStmt2 = conn.prepareStatement(sql2);
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
				if (param.getB_pic() != null && !param.getB_pic().equals("")) {
					pStmt.setString(3, param.getB_pic());
				}
				else {
					pStmt.setString(3, "");
				}
	System.out.println("dao125さん");

	System.out.println("dao136さん");

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



// 最後は検索の処理！
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Buytters> search(Buytters param) {
		Connection conn = null;
		List<Buytters> buyeetList = new ArrayList<Buytters>();
		try {
		// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

		// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
			// シンプルにSELECTのSQL文記述してるだけ。
			// ？には↓記述の「setString」が入るよ。
			// ↓この文の最後に「order by id desc」って書いてて、
			// これが「id順(降順)」って意味だよ。
//			String sql = "select buytters.id as b_id, user_id, b_comment, b_pic, buytters.created_at as b_created from buytters where b_comment like ? order by id desc";
			String sql = "select buytters.id, user_id, b_comment, b_pic, buytters.created_at, buyte_sum from (select buytters.id, user_id, b_comment, b_pic, buytters.created_at from buytters where b_comment like ?)buytters, (select buyte_id, sum(buyte_count) as buyte_sum from nicebuycounts group by buyte_id)nicebuycounts where id = buyte_id order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
			// 検索欄の番号になんか打ち込まれてた時の検索処理
			// 「%(打ち込まれた単語)%」で曖昧検索してデータ持ってくるよ
			if (param.getB_comment() != null) {
				pStmt.setString(1, "%" + param.getB_comment() + "%");
			}
			// 検索欄の番号が空欄(null)の時の処理
			// 「%」(すべて対象)で曖昧検索してデータ持ってくるよ
			else {
				pStmt.setString(1, "%");
			}
		// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
		// 結果表をコレクションにコピーする
			// コレクションは可変長配列のやつの事だよ。
			while (rs.next()) {
				Buytters card = new Buytters(
				rs.getString("id"),
				rs.getString("user_id"),
				rs.getString("b_comment"),
				rs.getString("b_pic"),
				rs.getString("created_at"),
				rs.getString("buyte_sum")
				);
				buyeetList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			buyeetList = null;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			buyeetList = null;
		}
		finally {

		// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					buyeetList = null;
				}
			}
		}

		// 結果を返す
			// 結果とはさっき作った可変長配列の結果表の事だよ。
			return buyeetList;
	}

}