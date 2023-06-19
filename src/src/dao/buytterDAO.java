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
	public ArrayList<Buytters> selectAll() {
		// 変数宣言
		Connection conn = null;

		// return用オブジェクトの生成
		ArrayList<Buytters> buyeetList = new ArrayList<Buytters>();

		try {
		// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

		// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
			// シンプルにSELECTのSQL文記述してるだけ。
			// ？には↓記述の「setString」が入るよ。
			// ↓この文の最後に「ORDER BY id desc」って書いてて、
			// これが「idの降順」って意味だよ。
			String sql = "select * from buytters where id and user_id and b_comment and b_pic and created_at order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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
				rs.getString("created_at")
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








// 最後は検索の処理！
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Buytters> select(Buytters param) {
		Connection conn = null;
		List<Buytters> buytterList = new ArrayList<Buytters>();

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
			String sql = "select * from Buytters where id and user_id and b_comment like ? and b_pic and created_at order by id desc";
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
				rs.getString("created_at")
				);
				buytterList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			buytterList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			buytterList = null;
		}
		finally {

		// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					buytterList = null;
				}
			}
		}

		// 結果を返す
			// 結果とはさっき作った可変長配列の結果表の事だよ。
			return buytterList;
	}

}