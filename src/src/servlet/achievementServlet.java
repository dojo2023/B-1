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

import dao.banksDAO;
import dao.goalsDAO;
import dao.paymentsDAO;
import dao.pointsDAO;
import model.Achievement;
import model.Payments;
/**
 * Servlet implementation class achievementServlet
 */
@WebServlet("/achievementServlet")
public class achievementServlet extends HttpServlet {
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

			// スコープのuserid
			String userid = (String)session.getAttribute("userid");

		// グラフの数値表示に関して↓
			// 検索処理を行う
			paymentsDAO pmtDAO = new paymentsDAO();
			List<Payments> paydetailList = pmtDAO.list(userid);

			// 格納する
			request.setAttribute("paydetailList",paydetailList);


		// 各金額の表示に関して↓


			// 貯金額を出す
			banksDAO bnkDAO = new banksDAO();
			int banks = bnkDAO.select(userid);
			System.out.println(banks);

			// 目標貯金額を出す
			goalsDAO gDAO = new goalsDAO();
			int goals = gDAO.select(userid);
			System.out.println(goals);

			// 支出合計を出す
			paymentsDAO payDAO = new paymentsDAO();
			int paymoney = payDAO.select(userid);
			System.out.println(paymoney);

			// ポイント数を出す
			pointsDAO pDAO = new pointsDAO();
			int points = pDAO.select(userid);
			System.out.println(points);

			// 格納する
			request.setAttribute("acv",
			new Achievement(banks,goals,paymoney, points ));


		    // achievement.jspに画面遷移（フォワード）
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/achievement.jsp");
		    dispatcher.forward(request, response);
		  }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	 // もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
	if (session.getAttribute("userid") == null) {
		response.sendRedirect("/Ifrit/loginServlet");
		return;
	}

    // フォワード
    RequestDispatcher dispatcher =
        request.getRequestDispatcher
            ("/WEB-INF/jsp/achievement.jsp");
    dispatcher.forward(request, response);
  }

}
