package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PictureBook;

public class charactersDAO {
	// pictureBookServletに図鑑のキャラ画像取得
	public List<PictureBook> select(String userid) {
		// 変数宣言
		Connection conn = null;

		List<PictureBook> pblist = new ArrayList<PictureBook>();
		int i = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select char_pic from charpics as p  join characters as c on c.char_id = p.char_id where c.user_id = ? and c_health = '0'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao37");

			// 結果表をコレクションにコピーする
			while (i<15) {
				if(rs.next()) {
					PictureBook card = new PictureBook(
							rs.getString("char_pic"));
					pblist.add(card);
					System.out.println(rs.getString("char_pic"));
				}else {
					PictureBook card = new PictureBook(
							"nazo.png");
					pblist.add(card);
					System.out.println("charDAO:51");

				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pblist = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pblist = null;
		} finally {

			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					pblist = null;
				}
			}
		}

		// 結果を返す
		// 結果とはさっき作った可変長配列の結果表の事だよ。
		return pblist;
	}
	//卵配布によるキャラクター設定
	public boolean setC(String userid,int charid) {
		Connection conn = null;

		boolean check = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "insert into characters(user_id,char_id) values (?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("dao29");

		//point１５０にした。
		pStmt.setInt(2,charid);
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
