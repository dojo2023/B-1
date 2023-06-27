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
		List<PictureBook> waitlist = new ArrayList<PictureBook>();
		int wait = 0;
		int i = 1;
		String si ="";


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SQL文を準備する
			String sql = "select char_pic, p.char_id from charpics as p  join characters as c on c.char_id = p.char_id where c.user_id = ? and c_health = '0' group by p.char_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
			pStmt.setString(1, userid);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			System.out.println("dao37");

			// 結果表をコレクションにコピーする
			while (i<15) {
				int j=999;
				String k = Integer.valueOf(i).toString();
				if(rs.next()) {
					j = rs.getInt("char_id");
					si = Integer.valueOf(j).toString();
					waitlist.add(new PictureBook(
							rs.getString("char_pic"),
							rs.getInt("char_id")));
					rs.getInt("char_id");
					System.out.println("char_id;charDAO"+j);
					System.out.println("si;charDAO:"+si);
					System.out.println("k;charDAO:"+k);

				}
				if(si.equals(k)) {
					pblist.add(waitlist.get(wait));
					wait++;
				}else {
					PictureBook card = new PictureBook(
							"nazo.png",999);
					pblist.add(card);
					System.out.println("charDAO:51");

				}
				System.out.println("i:::"+i);
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
