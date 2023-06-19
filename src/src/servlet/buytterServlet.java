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

		// もしもログインしていなかったらloginServlet.javaにリダイレクトする
			  HttpSession session = request.getSession();
				if (session.getAttribute("userid") == null) {
					response.sendRedirect("/Ifrit/loginServlet");
					return;
				}

		  // ログイン情報があれば、最終的にbuytter.jspにフォワードしたい
		  // top画面はTL画面で、最新buyeet順(id降順)に表示

				String id = "";
				String user_id = "";
				String b_comment = "";
				String b_pic = "";
				String created_at = "";

		  // buytterDAOのオブジェクト宣言
		  buytterDAO objDao = new buytterDAO();

//		  List<Buytters> buyeetList= objDao.select(new Buytters(id, user_id, b_comment, b_pic, created_at));
		  List<Buytters> buyeetList= objDao.select(new Buytters(id, user_id, b_comment, b_pic, created_at));

		  // 並び変えた投稿をリクエストスコープに格納する
		  request.setAttribute("buyeetList", buyeetList);

		// buytter.jspにフォワードするよ
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/buytter.jsp");
			    dispatcher.forward(request, response);
		  }


// 次はPOSTリクエストの処理
// nice buyボタン押された時、バイートボタン押された時、検索ボタン押された時

//	  	/**
//		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//		 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// もしもログインしていなかったらloginServlet.javaにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("userid") == null) {
//			response.sendRedirect("/Ifrit/loginServlet");
//			return;
//		}
//
//		//セッションスコープにあるuseridを取得
//		String user_id = (String)session.getAttribute("userid");
//
//	// まずはnice buyボタン押された時の処理
//
//
//
//	// 投稿(バイート)ボタン押された時の処理
//
//		if (request.getParameter("postSubmit").equals("バイートする")) {
//
//			// リクエストパラメータを取得する
//			request.setCharacterEncoding("UTF-8");
//			String b_comment = request.getParameter("postComment");
//			String b_pic = request.getParameter("postPic");
//
//			// 登録処理を行う
//			buytterDAO objDao = new buytterDAO();
//
//			// スコープのuser_idをSQL文でInsertしたいけどできない！！
//			objDao.insert(new Buytters(user_id, b_comment, b_pic));
//			request.setAttribute("Buytters",new Buytters);
//
//
//
////			// 投稿成功
////			if (buytterDao.insert(new buytter(b_comment, b_pic))) {
////				request.setAttribute("result",
////				new Result("投稿成功！", "buyeetを投稿しました。", "/Ifrit/resultServlet"));
////			}
////			// 投稿失敗
////			else {
////				request.setAttribute("result",
////				new Result("投稿失敗！", "buyeetを投稿できませんでした。", "/Ifrit/resultServlet"));
////			}
////		}
//
//
//	// 最後は検索ボタン押された時の処理
//
//		if (request.getParameter("searchSubmit").equals("検索ボタン")) {
//
//			// リクエストパラメータを取得する
//			request.setCharacterEncoding("UTF-8");
//			String b_comment = request.getParameter("searchBox");
//
//
//			// buytterDAOのオブジェクト宣言
//			buytterDAO objDao = new buytterDAO();
//			List<Buytters> buytterList = objDao.select(new Buytters(b_comment));
//			// 検索結果をリクエストスコープに格納する
//			request.setAttribute("buytterList", buytterList);
//		}
//
//	// 処理が終わったらTL画面にフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buytter.jsp");
//		dispatcher.forward(request, response);
//	}
}
