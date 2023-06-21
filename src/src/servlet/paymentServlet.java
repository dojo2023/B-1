package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
			System.out.println("37");
			//セッションスコープにあるuseridを取得
			String userid = (String)session.getAttribute("userid");
			System.out.print(userid);
			String date;
			String daypm;
			int wa;
//			try {
			//取得したリンクから、年月日を取得し、それをもとにDBから探す。
			//String date =request.getParameter("submit");
			//いったん例として日時指定してやる。
			date = "2023-06-20";
			SimpleDateFormat kata = new SimpleDateFormat("yyyy-MM-dd");
			Date nowday = kata.parse(date);
			//日時計算用に変更
			daykata = new SimpleDateFormat"yyyy/MM/dd");
			//目標日を取得
			goalsDAO gd = new goalsDAO();
			Date day = daykata.parse(gd.ggoal(userid));
			//ふたつを計算
			long ndate = date.getTime();
			long gdate = day.getTime();
			long oneday = 1000*60*60*24;
			long daysa = (ndate - gdate)/oneday;

			//フォーマット指定
//			String date = new SimpleDateFormat("yyyy-MM-dd");
//				Date date = sdformat.parse(pushTime);
//			} catch (ParseException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
			//今日の日付表示用
			request.setAttribute("today", date);


			//検索処理
			paymentsDAO payDAO = new paymentsDAO();
			List<Payments> paymentsList = payDAO.search(userid,date);

			System.out.println();
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("paymentsList", paymentsList);
			System.out.println("61");
			//合計の出力
			wa = payDAO.sum(userid, date);
			Integer goukei = new Integer(wa);
			System.out.println("合計:"+goukei);

			//合計をリクエストスコープに格納する
			request.setAttribute("paymoney",goukei);

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/payment.jsp");
		    dispatcher.forward(request, response);
			System.out.println("67");
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

		int payMoney = Integer.parseInt(paymoney);
		System.out.println(category);
		System.out.println(paymoney);
		// 検索処理を行う
		paymentsDAO payDAO = new paymentsDAO();
		boolean check = payDAO.insert(new Payments(category, payMoney),userid);

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




