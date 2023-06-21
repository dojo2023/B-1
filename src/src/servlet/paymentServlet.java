package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
//			if (session.getAttribute("userid") == null) {
//				response.sendRedirect("/Ifrit/loginServlet");
//				return;
//			}

			//セッションスコープにあるuseridを取得
			String userid = (String)session.getAttribute("userid");
			System.out.print(userid);
			String date;
			String daypm;
			int wa;
			String sdaypm;
			String goalday;
			String gdaypm;
			try {
			//取得したリンクから、年月日を取得し、それをもとにDBから探す。
			//String date =request.getParameter("submit");
			//いったん例として日時指定してやる。
//			 リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			daypm = request.getParameter("Submit2");
			daypm ="2023-06-21";
//			sdaypm = daypm.replace("-","/");
//			System.out.println("送られてきた値"+daypm);
//			SimpleDateFormat kata = new SimpleDateFormat("yyyy/MM/dd");
//			System.out.println("58");
//			Date nowday = kata.parse(sdaypm);
//			System.out.println("60");
//			//日時計算用に変更
//			SimpleDateFormat daykata = new SimpleDateFormat("yyyy/MM/dd");
//			System.out.println("63");
//			//目標日を取得
//			goalsDAO gd = new goalsDAO();
//			System.out.println("7070");
//			goalday = gd.getlimit(userid);
//			System.out.println("7272");
//			gdaypm = goalday.replace("-","/");
//			Date day = daykata.parse(gdaypm);
//			System.out.println("67");
//			System.out.println(day);
//			//ふたつを計算
//			long ndate = nowday.getTime();
//			System.out.println("71");
//			long gdate = day.getTime();
//			System.out.println("73");
//			long oneday = 1000*60*60*24;
//			System.out.println("75");
//			long daysa = (ndate - gdate)/oneday;
//			System.out.println("77");
//			int myInt = Math.toIntExact(daysa);
//			System.out.println("79");
//
//			System.out.println("何日"+daysa);
//
//			//フォーマット指定
//			SimpleDateFormat last = new SimpleDateFormat("yyyy-MM-dd");
//				Date daoDay = last.parse(daypm);

			//今日の日付表示用
			request.setAttribute("today", daypm);


			//検索処理
			paymentsDAO payDAO = new paymentsDAO();
			List<Payments> paymentsList = payDAO.search(userid,daypm);

			System.out.println();
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("paymentsList", paymentsList);
			System.out.println("p61");
			//合計の出力
			wa = payDAO.sum(userid, daypm);
			Integer goukei = new Integer(wa);
			System.out.println("合計:"+goukei);

			//合計をリクエストスコープに格納する
			request.setAttribute("paymoney",goukei);

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/payment.jsp");
		    dispatcher.forward(request, response);
			System.out.println("p67");
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		  }


	  //今日使える金額と支出合計のDaoの処理など未入力

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession session = request.getSession();
		//セッションスコープにあるuseridを取得
		String userid = (String)session.getAttribute("userid");
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("paymentCategory");
		String paymoney = request.getParameter("paymoney");
		String daypm = request.getParameter("pay_date");
		int payMoney = Integer.parseInt(paymoney);
		System.out.println(category);
		System.out.println(paymoney);
		// 検索処理を行う
		paymentsDAO payDAO = new paymentsDAO();
		boolean check = payDAO.insert(new Payments(category, payMoney),userid,daypm);

		if(check) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}

		// フォワード
	    RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp");
	    dispatcher.forward(request, response);
	  }
	}




