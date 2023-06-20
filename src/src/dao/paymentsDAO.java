package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Payments;

public class paymentsDAO {

public List<Payments> search(String userid) {
	Connection conn = null;
	List<Payments> paymentsList = new ArrayList<Payments>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select * from payments where user_id = ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1, userid);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Payments paycard = new Payments(
			rs.getString("paycategory"),
			rs.getInt("paymoney")
			);
			paymentsList.add(paycard);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		paymentsList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		paymentsList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				paymentsList = null;
			}
		}
	}

	// 結果を返す
	return paymentsList;
}

//paymentServletでのカテゴリと支出の格納
public boolean insert(Payments Payments,String userid) {
	Connection conn = null;
	boolean check = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");


		// SQL文を準備する
		String sql = "insert into payments(pay_category,pay_money,user_id) values (?,?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);


		// SQL文を完成させる
		if (Payments.getPaycategory() != null && !Payments.getPaycategory() .equals("")) {
			pStmt.setString(1, Payments.getPaycategory());
		}else{
			pStmt.setString(1, "");
		}
		pStmt.setInt(2, Payments.getPaymoney());

		pStmt.setString(3, userid);

		// SQL文を実行する
		if(pStmt.executeUpdate() == 1) {
			check = true;
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		check = false;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		check = false;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				check = false;
			}
		}
	}

	// 結果を返す
	return check;
}


// achievementServletの支出合計取得のselect
public int select(String userid) {
	Connection conn = null;

	int sisyutsu;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select sum (pay_money) from payments where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		sisyutsu = rs.getInt("pay_money");
	}
	catch (SQLException e) {
		e.printStackTrace();
		sisyutsu = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		sisyutsu = 0;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				sisyutsu = 0;
			}
		}
	}

// 結果を返す
return sisyutsu;
}
}