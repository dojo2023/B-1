package servlet;

import java.io.IOException;

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
	    // 欲しいもの名を出す
			goalsDAO gd = new goalsDAO ();
			String gwant = gd.getwant(userid);
			System.out.println(gwant);

		// 残り日数(glimit - 今日)
			goalsDAO gdao = new goalsDAO();
			int glimit = gdao.calendarlimit(userid);
			System.out.println(glimit);

		// キャラ背景画像
			charpicsDAO cdao = new charpicsDAO();
			String charpic = cdao.charpic(userid);
			System.out.println(charpic);

		// 貯金額を出す
			banksDAO bnkDAO = new banksDAO();
			int banks = bnkDAO.select(userid);
			System.out.println(banks);
		// 目標貯金額を出す
			goalsDAO gDAO = new goalsDAO();
			int goals = gDAO.select(userid);
			System.out.println(goals);


			// データを格納する
						request.setAttribute("wnt",
						new CalendarDate(gwant,glimit,charpic,banks,goals ));
		    // フォワード
		    RequestDispatcher dispatcher =
		    	request.getRequestDispatcher
		            ("/WEB-INF/jsp/calendar.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
