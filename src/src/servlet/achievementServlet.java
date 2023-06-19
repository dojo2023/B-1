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
import dao.pointsDAO;
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


			// 検索処理を行う
			banksDAO bnkDAO = new banksDAO();
			List<Payments> paymentsList = payDAO.list(new Payments(category, payMoney));

			// 検索処理を行う
			pointsDAO pDAO = new pointsDAO();
			List<Payments> paymentsList = payDAO.list(new Payments(category, payMoney));


		    // フォワード
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
