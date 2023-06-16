package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.idpwsDAO;
import dao.paymentsDAO;
import dao.buyttersDAO;
import dao.goalsDAO;
import dao.charactersDAO;
import dao.charpicsDAO;
import dao.nicebuycountsDAO;
import dao.pointsDAO;
import dao.historysDAO;
import dao.itemspicsDAO;
import dao.itemsDAO;
import dao.banksDAO;
import model.Idpws;
import model.Payments;
import model.Result;
import model.Buytters;
import model.Calendar;
import model.CalendarDate;
import model.Room;
import model.Achievement;
import model.Ranking;
import model.ResultGoals;
import model.Character;
import model.PictuerBook;
import model.Result;
import model.DressUp;

/**
 * Servlet implementation class dressServlet
 */
@WebServlet("/dressServlet")
public class dressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doGet(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {

		 	// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/Ifrit/loginServlet");
				return;
			}
			//ユーザの保有ポイントをDAOで持ってくる

			//装飾品の画像をDAOで持ってくる

			//装飾品の値段をDAOで持ってくる

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/dress.jsp");
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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Ifrit/loginServlet");
			return;
		}


		// 着替えるボタン押下
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
		request.setCharacterEncoding("UTF-8");
		String dressup = request.getParameter("dressup");

		// 処理を行う （SQLを動作させるDAO）
		// 訂正必要！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		itemspicsDao ipicDao= new itemspicsDao(); //インスタンス化したもの
		if (ipicDao.isOK(new ipic(userid, userpw))) {	//


		// 購入ボタン押下
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
		request.setCharacterEncoding("UTF-8");
		String buy = request.getParameter("buy");

		// 処理を行う （SQLを動作させるDAO）
		// 訂正必要！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		itemspicsDao ipicDao= new itemspicsDao(); //インスタンス化したもの
		if (ipicDao.isOK(new ipic(userid, userpw))) {	//





	    // フォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher
	            ("/WEB-INF/jsp/dress.jsp");
	    dispatcher.forward(request, response);
	  }
	}

}
