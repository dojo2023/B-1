package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/Ifrit/loginServlet");
				return;
			}


		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/payment.jsp");
		    dispatcher.forward(request, response);
		  }

	  //今日使える金額と支出合計のDaoの処理など未入力

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



		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("paycategory");
		String paymoney = request.getParameter("paymoney");

		//Daoで多分処理

		// 支出入力結果をリクエストスコープに格納する
		request.setAttribute(paymentList,"paymentList" );

		// フォワード
	    RequestDispatcher dispatcher =
	        request.getRequestDispatcher
	            ("/WEB-INF/jsp/payment.jsp");
	    dispatcher.forward(request, response);
	  }
	}




