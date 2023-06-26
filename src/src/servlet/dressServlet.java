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

import dao.goalsDAO;
import dao.itemspicsDAO;
import dao.pointsDAO;
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
			if (session.getAttribute("userid") == null) {
				response.sendRedirect("/Ifrit/loginServlet");
				return;
			}

			// スコープのuserid
			String userid = (String)session.getAttribute("userid");

			// キャラクターの名前を持ってくる
			goalsDAO gDAO = new goalsDAO();
			String names = gDAO.getcname(userid);
			System.out.println(names);

			// リクエストスコープに格納
			request.setAttribute("names",names);
			System.out.println(names);


			//ユーザの保有ポイントをDAOで持ってくる
			pointsDAO pDAO = new pointsDAO();
			int points = pDAO.select(userid);
			System.out.println(points);

			// リクエストスコープに格納
			request.setAttribute("points",points);
			System.out.println(points);


			//装飾品の画像をDAOで持ってくる
			itemspicsDAO iDAO = new itemspicsDAO();
			List <DressUp> Dress= iDAO.select(userid);
			System.out.println(Dress);

			//格納する
			request.setAttribute("Dress",
					Dress);


/* 一旦保留
			//装飾品の値段をDAOで持ってくる
			itemspicsDAO ipDAO = new itemspicsDAO();
			int itemprice = ipDAO.iprice(userid);
			System.out.println(itemprice);

			//装飾品の購入判断？
			itemspicsDAO ibDAO = new itemspicsDAO();
			int itembuy = ibDAO.iprice(userid);
			System.out.println(itembuy);

			// リクエストスコープに格納する
			request.setAttribute("dress",
			new DressUp(itempics,itemprice,itembuy ));
*/

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
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/Ifrit/loginServlet");
			return;
		}


		// 着替えるボタン押下
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
		//request.setCharacterEncoding("UTF-8");
		//String dressup = request.getParameter("dressup");

		// 処理を行う （SQLを動作させるDAO）
		// 訂正必要！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		//itemspicsDao ipicDao= new itemspicsDao(); //インスタンス化したもの
		//if (ipicDao.isOK(new ipic(userid, userpw))) {	//


		// 購入ボタン押下
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
		//request.setCharacterEncoding("UTF-8");
		//String buy = request.getParameter("buy");

		// 処理を行う （SQLを動作させるDAO）
		// 訂正必要！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		//itemspicsDao ipicDao= new itemspicsDao(); //インスタンス化したもの
		//if (ipicDao.isOK(new ipic(userid, userpw))) {	//





	    // フォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher
	            ("/WEB-INF/jsp/dress.jsp");
	    dispatcher.forward(request, response);
	  }
	}


