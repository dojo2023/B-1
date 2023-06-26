package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import dao.paymentsDAO;
import model.Payments;

/**
 * Servlet implementation class paymentServlet
 */
@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//			// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/Ifrit/loginServlet");
			return;
		}

		//セッションスコープにあるuseridを取得
		String userid = (String) session.getAttribute("userid");
		System.out.println("userid:" + userid);
		String date;
		String daypm;
		int wa;
		String sdaypm;
		String goalday;
		String gdaypm;
		int gavailable;
		try {
			//取得したリンクから、年月日を取得し、それをもとにDBから探す。
			//String date =request.getParameter("submit");
			//いったん例として日時指定してやる。
			//			 リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			daypm = request.getParameter("Submit2");
			System.out.println("daypm:" + daypm);
			//			daypm = "2023-06-21";
			//目標設定日を取得
			goalsDAO gd = new goalsDAO();
			Timestamp gCreate = gd.getCreate(userid);
			SimpleDateFormat daykata = new SimpleDateFormat("yyyy/MM/dd");
			String created = daykata.format(gCreate);
			//取得した目標設定日をDate型にする。
			sdaypm = created.replace("-", "/");
			System.out.println("送られてきた値" + sdaypm);
			System.out.println("58");
			Date nowday = DateFormat.getDateInstance().parse(sdaypm);
			System.out.println(nowday);
			//日時計算用に変更

			System.out.println("63");
			//目標日を取得
			System.out.println("7070");
			goalday = gd.getlimit(userid);
			System.out.println("goalday:" + goalday);
			gdaypm = goalday.replace("-", "/");
			//先頭２文字大文字から小文字に変換
			//			String str = "ABCDEFG";
			gdaypm = gdaypm.substring(0, 2).toLowerCase() + gdaypm.substring(2);
			//			str = str.substring(0,2).toLowerCase()+str.substring(2);
			System.out.println("gdaypm1:" + gdaypm);
			//			System.out.println("str:"+str);
			gdaypm = gdaypm.substring(0, 8) + gdaypm.substring(gdaypm.length() - 2).toLowerCase();
			//			str = str.substring(0,6)+str.substring(str.length()-2).toLowerCase();
			System.out.println("gdaypm2:" + gdaypm);
			//			System.out.println("str2:"+str);
			Date day = DateFormat.getDateInstance().parse(gdaypm);
			System.out.println("67");
			System.out.println(day);
			//ふたつを計算
			long ndate = nowday.getTime();
			System.out.println("71");
			long gdate = day.getTime();
			System.out.println("73");
			long oneday = 1000 * 60 * 60 * 24;
			System.out.println("75");
			long daysa = (gdate - ndate) / oneday;
			System.out.println("77");
			int myInt = Math.toIntExact(daysa);
			System.out.println("79");

			System.out.println("何日" + daysa);
			System.out.println("ｍYINT" + myInt);

			//使用可能額取得
			gavailable = Integer.parseInt(gd.getavailable(userid));

			myInt = gavailable / myInt;

			//			//フォーマット指定
			//			SimpleDateFormat last = new SimpleDateFormat("yyyy-MM-dd");
			//				Date daoDay = last.parse(daypm);

			//今日の日付表示用
			request.setAttribute("today", daypm);

			//検索処理
			paymentsDAO payDAO = new paymentsDAO();
			List<Payments> paymentsList = payDAO.search(userid, daypm);

			System.out.println();
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("paymentsList", paymentsList);
			System.out.println("p61");
			//合計の出力
			wa = payDAO.sum(userid, daypm);
			Integer goukei = (Integer)wa;
			System.out.println("合計:" + goukei);

			//合計をリクエストスコープに格納する
			request.setAttribute("paymoney", goukei);
			//今日使える金額を計算し、格納
			myInt = myInt - wa;
			Integer myint = (Integer)myInt;
			request.setAttribute("gavailable", myint);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp");
			dispatcher.forward(request, response);
			System.out.println("doget終わり！！");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//今日使える金額と支出合計のDaoの処理など未入力

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		HttpSession session = request.getSession();
		//セッションスコープにあるuseridを取得
		String userid = (String) session.getAttribute("userid");
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("paymentCategory");
		String paymoney = request.getParameter("paymoney");
		String daypmm = request.getParameter("payment_date");
		int payMoney = Integer.parseInt(paymoney);
		System.out.println(category);
		System.out.println(paymoney);
		// 検索処理を行う
		paymentsDAO payDAO = new paymentsDAO();
		boolean check = payDAO.insert(new Payments(category, payMoney), userid, daypmm);

		if (check) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
		System.out.println("userid:" + userid);
		String date;
		String daypm;
		int wa;
		String sdaypm;
		String goalday;
		String gdaypm;
		int gavailable;
		try {
			//取得したリンクから、年月日を取得し、それをもとにDBから探す。
			//String date =request.getParameter("submit");
			//いったん例として日時指定してやる。
			//		 リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			daypm = request.getParameter("Submit2");
			daypm = "2023-06-21";
			sdaypm = daypm.replace("-", "/");
			System.out.println("送られてきた値" + sdaypm);
			//		SimpleDateFormat kata = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println("58");
			Date nowday = DateFormat.getDateInstance().parse(sdaypm);
			System.out.println(nowday);
			//日時計算用に変更
			SimpleDateFormat daykata = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println("63");
			//目標日を取得
			goalsDAO gd = new goalsDAO();
			System.out.println("7070");
			goalday = gd.getlimit(userid);
			System.out.println("goalday:" + goalday);
			gdaypm = goalday.replace("-", "/");
			//先頭２文字大文字から小文字に変換
			//		String str = "ABCDEFG";
			gdaypm = gdaypm.substring(0, 2).toLowerCase() + gdaypm.substring(2);
			//		str = str.substring(0,2).toLowerCase()+str.substring(2);
			System.out.println("gdaypm1:" + gdaypm);
			//		System.out.println("str:"+str);
			gdaypm = gdaypm.substring(0, 8) + gdaypm.substring(gdaypm.length() - 2).toLowerCase();
			//		str = str.substring(0,6)+str.substring(str.length()-2).toLowerCase();
			System.out.println("gdaypm2:" + gdaypm);
			//		System.out.println("str2:"+str);
			Date day = DateFormat.getDateInstance().parse(gdaypm);
			System.out.println("67");
			System.out.println(day);
			//ふたつを計算
			long ndate = nowday.getTime();
			System.out.println("71");
			long gdate = day.getTime();
			System.out.println("73");
			long oneday = 1000 * 60 * 60 * 24;
			System.out.println("75");
			long daysa = (gdate - ndate) / oneday;
			System.out.println("77");
			int myInt = Math.toIntExact(daysa);
			System.out.println("79");

			System.out.println("何日" + daysa);
			System.out.println("ｍYINT" + myInt);

			//使用可能額取得
			gavailable = Integer.parseInt(gd.getavailable(userid));

			myInt = gavailable / myInt;

			//		//フォーマット指定
			//		SimpleDateFormat last = new SimpleDateFormat("yyyy-MM-dd");
			//			Date daoDay = last.parse(daypm);

			//今日の日付表示用
			request.setAttribute("today", daypm);

			//検索処理
			List<Payments> paymentsList = payDAO.search(userid, daypm);

			System.out.println();
			// 検索結果をリクエストスコープに格納する

			//			System.out.println("p61");
			//合計の出力
			wa = payDAO.sum(userid, daypm);
			Integer goukei = new Integer(wa);
			//			System.out.println("合計:" + goukei);

			//合計をリクエストスコープに格納する

			//今日使える金額を計算し、格納
			myInt = myInt - wa;
			Integer myint = new Integer(myInt);

			request.setAttribute("paymoney", goukei);
			request.setAttribute("paymentsList", paymentsList);
			request.setAttribute("gavailable", myint);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp");
			dispatcher.forward(request, response);
			System.out.println("p67");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
