package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.idpwsDAO;
import dao.paymentsDAO;
import dao.buytterDAO;
import dao.goalsDAO;
import dao.charactersDAO;
import dao.charpicsDAO;
import dao.nicebuyDAO;
import dao.pointsDAO;
import dao.historysDAO;
import dao.itemspicsDAO;
import dao.banksDAO;
import model.Idpws;
import model.Payments;
import model.Result;
import model.Buytters;
import model.LoginUser;
import model.Calendar;
import model.CalendarDate;
import model.Room;
import model.Achievement;
import model.Ranking;
import model.ResultGoals;
import model.Character;
import model.PictureBook;
import model.Result;
import model.DressUp;
import model.Goals;
/**
 * Servlet implementation class setGoalsServlet
 */
@WebServlet("/setGoalsServlet")
public class setGoalsServlet extends HttpServlet {
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


		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/setGoals.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doPost(request, response);

	request.setCharacterEncoding("UTF-8");
	// リクエストパラメータを取得する
	String goal = request.getParameter("ggoal");
	int ggoal = Integer.parseInt(goal);

	String available = request.getParameter("gavailable");
	int gavailable  = Integer.parseInt(available);

	String limit = request.getParameter("glimit");

	String want = request.getParameter("gwant");

	// 登録処理を行う
	goalsDAO gd =  new goalsDAO();
	boolean check = gd.setGoal(new Goals(ggoal,gavailable,limit,want));




	// 結果ページにフォワードする
		RequestDispatcher dispatcher =
			request.getRequestDispatcher
				("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);

}
