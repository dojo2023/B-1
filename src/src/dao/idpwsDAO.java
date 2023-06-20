package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Idpws;

public class idpwsDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Idpws Idpws) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from idpws where user_id = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Idpws.getUserid());
			pStmt.setString(2,Idpws.getUserpw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
	public boolean register(Idpws idpws) {
		Connection conn = null;
		boolean hanbetu = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");


			// SQL文を準備する
			String sql = "insert into idpws(user_id,user_pw,user_name) values (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println("77");
			// SQL文を完成させる
			if (idpws.getUserid() != null && !idpws.getUserid().equals("")) {
				pStmt.setString(1, idpws.getUserid());
				System.out.println("82");
			}

			else {
				pStmt.setString(1, "");
				System.out.println("87");
			}

			if (idpws.getUserpw() != null && !idpws.getUserpw().equals("")) {
				pStmt.setString(2, idpws.getUserpw());
				System.out.println("92");
			}
			else {
				pStmt.setString(2, "");
				System.out.println("96");
			}
			if (idpws.getUsername() != null && !idpws.getUsername().equals("")) {
				pStmt.setString(3, idpws.getUsername());
				System.out.println("100");
			}

			else {
				pStmt.setString(3, "");
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

}