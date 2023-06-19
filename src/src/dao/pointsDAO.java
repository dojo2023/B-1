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

public List<Payments> list(Payments Payments) {
	Connection conn = null;
	List<Payments> paymentsList = new ArrayList<Payments>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/B1", "sa", "");

		// SQL文を準備する
		String sql = "select * from payments";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる


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
}
