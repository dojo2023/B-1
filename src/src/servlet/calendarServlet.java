package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.banksDAO;
import dao.charpicsDAO;
import dao.goalsDAO;
import model.CalendarDate;
/**
 * Servlet implementation class calendarServlet
 */
@WebServlet("/calendarServlet")
public class calendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("userid") == null) {
				response.sendRedirect("/Ifrit/loginServlet");
				return;
		}

			String userid = (String)session.getAttribute("userid");
			System.out.println("USERID："+userid);
	    // 欲しいもの名を出す
			try {

			goalsDAO gd = new goalsDAO ();
			String gwant = gd.getwant(userid);
			System.out.println(gwant);

		// 残り日数(glimit - 今日)
			goalsDAO gdao = new goalsDAO();
			String glimit = gdao.getlimit(userid);
			System.out.println(glimit);
			Date date = new Date();
			Date limitday;
			glimit = glimit.replace("-", "/");
			limitday = DateFormat.getDateInstance().parse(glimit);

			long limit = limitday.getTime(); //残り日数を計算する
			System.out.println("71");
			long today = date.getTime();
			System.out.println("73");
			long oneday = 1000 * 60 * 60 * 24;
			System.out.println("75");
			long daysa = (limit - today) / oneday;
			System.out.println("77");
			int myInt = Math.toIntExact(daysa);
			System.out.println("79");

			System.out.println("何日" + daysa);
			System.out.println("ｍYINT" + myInt);

		// 貯金額を出す
			banksDAO bnkDAO = new banksDAO();
			int banks = bnkDAO.select(userid);
			System.out.println(banks);
		// 目標貯金額を出す
			goalsDAO gDAO = new goalsDAO();
			int goals = gDAO.select(userid);
			System.out.println(goals);

			// ヘルスを取り出す
						charpicsDAO cdaohealth = new charpicsDAO();
						int health = cdaohealth.health(userid);
						System.out.println("ヘルスさん"+health);
			// キャラ画像を取り出す
				charpicsDAO cdaoCharpic = new charpicsDAO();
				String charpic = cdaoCharpic.pic(health, userid);
				System.out.println("キャラ画像さん"+charpic);
			// キャラ背景画像を取り出す
				//目標達成度を取り出す
				int gratio = banks / goals * 100;
				if(gratio >= 100) {
					gratio = 100;
				}
				// 目標達成度から背景画像を表示
				String backpic;
				if(gratio <= 25) {
					backpic="blue1.png";
				}
				else if(gratio <= 50) {
					backpic="blue2.png";
				}
				else if(gratio <= 75) {
					backpic="blue3.png";
				}
				else{
					backpic="blue4.png";
				}
				System.out.println("キャラ背景画像さん"+backpic);


			// データを格納する
						request.setAttribute("wnt",
						new CalendarDate(gwant,myInt,charpic,backpic,banks,goals ));
		    // フォワード
		    RequestDispatcher dispatcher =
		    	request.getRequestDispatcher
		            ("/WEB-INF/jsp/calendar.jsp");
		    dispatcher.forward(request, response);
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
