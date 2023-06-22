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
//paymentsの日による支出の表示
public List<Payments> search(String userid,String date) {
	Connection conn = null;
	List<Payments> paymentsList = new ArrayList<Payments>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select * from payments where user_id=? and pay_date like ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		System.out.println("dao送られてきた値"+date);
		// SQL文を完成させる
		pStmt.setString(1, userid);
		pStmt.setString(2,date);
		System.out.println("dao33");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("dao36");
		// 結果表をコレクションにコピーする
		while (rs.next()) {
			Payments paycard = new Payments(
			rs.getString("pay_category"),
			rs.getInt("pay_money")
			);
			paymentsList.add(paycard);
			System.out.println(rs.getString("pay_category"));
			System.out.println(rs.getInt("pay_money"));
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
	System.out.print("dao67");
	// 結果を返す
	return paymentsList;
}

//paymentServletでのカテゴリと支出の格納
public boolean insert(Payments Payments,String userid,String paydate) {
	Connection conn = null;
	boolean check = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");


		// SQL文を準備する
		String sql = "insert into payments(pay_category,pay_money,user_id,pay_date) values (?,?,?,?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		System.out.println("dao88");


		// SQL文を完成させる
//		if (Payments.getPaycategory() != null && !Payments.getPaycategory() .equals("")) {
		pStmt.setString(1, Payments.getPaycategory());
		System.out.println("dao94");
//		}else{
//			pStmt.setString(1, "");
//		}
		pStmt.setInt(2, Payments.getPaymoney());
		System.out.println("dao99");

		pStmt.setString(3, userid);
		System.out.println("dao102");
		pStmt.setString(4, paydate);
		// SQL文を実行する
		if(pStmt.executeUpdate() == 1) {
			check = true;
			System.out.println("da106");
		}
		System.out.println("dao108");
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
		String sql = "select sum(pay_money) from payments where user_id=?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる(servletから取得したuserid(11.のString userid)をSQLに入れる)
		pStmt.setString(1, userid);
		System.out.println("dao157");

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("dao161");

		// 結果表をコレクションにコピーする
		rs.next();
		sisyutsu = rs.getInt("sum(pay_money)");
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
	System.out.println("dao186");
// 結果を返す
return sisyutsu;
}


public int sum(String userid,String date) {
	Connection conn = null;
	int wa = 0;
	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select sum(pay_money) from payments where user_id=? and pay_date like ?";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		pStmt.setString(1, userid);
		pStmt.setString(2,date);
		System.out.println("dao206");
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		// 結果を格納
		rs.next();
		wa = rs.getInt("sum(pay_money)");
		System.out.println(wa);
		System.out.println("dao2");
	}
	catch (SQLException e) {
		e.printStackTrace();
		wa = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		wa = 0;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				wa = 0;
			}
		}
	}
	System.out.print("dao67");
	// 結果を返す
	return wa;
}



//achievementの支出グラフ
public List<Payments> list(String userid) {
	Connection conn = null;
	List<Payments> paydetailList = new ArrayList<Payments>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select pay_category,sum(pay_money) from payments where  user_id=? group by pay_category";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		System.out.println("dao1");

		// SQL文を完成させる
		pStmt.setString(1, userid);
		System.out.println("dao2");



		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();
		System.out.println("dao3");

		// 結果表をコレクションにコピーする
		while(rs.next()){
			Payments paydetail = new Payments(
					rs.getString("pay_category"),
					rs.getInt("sum(pay_money)")
					);

			paydetailList.add(paydetail);
		}

	}
	catch (SQLException e) {
		e.printStackTrace();
		paydetailList= null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		paydetailList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				paydetailList = null;
			}
		}
	}
	return paydetailList;
	}

}


