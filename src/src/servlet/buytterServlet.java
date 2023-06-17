package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.buytterDAO;
import model.Buytters;
@WebServlet("/buytterServlet")
public class buytterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


// まずはGetリクエストの処理
// (「URLの入力」がされた時 or「この画面に遷移」の入力がされた時)

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest request,HttpServletResponse response)
			  throws ServletException, IOException {

//		// もしもログインしていなかったらloginServlet.javaにリダイレクトする
//			HttpSession session = request.getSession();
//			if (session.getAttribute("userid") == null) {
//				response.sendRedirect("/Ifrit/loginServlet");
//				return;
//			}

		  // ログイン情報があれば、最終的にbuytter.jspにフォワードしたい
		  // top画面はTL画面で、最新buyeet順に表示

		  // 配列宣言
		  ArrayList<Buytters> buyeetList = new ArrayList<Buytters>();

		  // buytterDAOのオブジェクト宣言
		  buytterDAO objDao = new buytterDAO();
		  buyeetList = objDao.selectAll();
		  // 検索結果をリクエストスコープに格納する
		  request.setAttribute("buyeetList", buyeetList);

		// buytter.jspにフォワードするよ
//		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/buytter.jsp").forward(request, response);
		  }


// 次はPOSTリクエストの処理
// nice buyボタン押された時、バイートボタン押された時、検索ボタン押された時

	  	/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//			HttpSession session = request.getSession();
//			if (session.getAttribute("userid") == null) {
//				response.sendRedirect("/Ifrit/LoginServlet");
//				return;
//			}

		// まずはnice buyボタン押された時の処理



		// バイートボタン押された時の処理



		// 最後は検索ボタン押された時の処理



	}
}
