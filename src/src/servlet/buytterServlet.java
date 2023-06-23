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
import dao.nicebuyDAO;
import model.Buytters;
import model.Nicebuy;
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

		  // buytterDAOのオブジェクト宣言
		  buytterDAO objDao = new buytterDAO();

		  List<Buytters> buyeetList= objDao.select();

		  // 並び変えた投稿をリクエストスコープに格納する
		  request.setAttribute("buyeetList", buyeetList);

		// buytter.jspにフォワードするよ
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buytter.jsp");
			    dispatcher.forward(request, response);
		  }


// 次はPOSTリクエストの処理

	  	/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// もしもログインしていなかったらloginServlet.javaにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("userid") == null) {
//			response.sendRedirect("/Ifrit/loginServlet");
//			return;
//		}
		// requestでもらった値をUTF-8に変換してるよ
			request.setCharacterEncoding("UTF-8");

//			int countsan = 6;

	// 投稿(バイート)ボタン押された時の処理

			if (request.getParameter("Submit").equals("バイートする")) {

				// リクエストパラメータを取得する
				String b_comment = request.getParameter("postComment");
				String b_pic = request.getParameter("postPic");

				//セッションスコープにあるuseridを取得
				HttpSession session = request.getSession();
				String user_id=(String)session.getAttribute("userid");
//					// 今まで書いてたやつ
//					String user_id = session.getAttribute("userid").toString();
//
//					// 今までの書き方で取得する書き方
//					LoginUser user_id_login = (LoginUser) session.getAttribute("userid");
//					String user_id=user_id_login.getId();

			// 登録処理を行う
			// buytterDAOのオブジェクト宣言
			buytterDAO objDao = new buytterDAO();
			if(objDao.insert(new Buytters(user_id, b_comment, b_pic))) {
				System.out.println("成功");

			}
			else {
				System.out.println("失敗");
			}

			// TL画面と同じ処理
			// buytterDAOのオブジェクト宣言
			  objDao = new buytterDAO();

			  List<Buytters> buyeetList= objDao.select();

			  // 並び変えた投稿をリクエストスコープに格納する
			  request.setAttribute("buyeetList", buyeetList);
			}

	//
	// 検索ボタン押された時の処理

			if (request.getParameter("Submit").equals("検索ボタン")) {

			// リクエストパラメータを取得する
			String b_comment = request.getParameter("searchBox");

			// buytterDAOのオブジェクト宣言
			buytterDAO objDao = new buytterDAO();
			List<Buytters> buyeetList = objDao.search(new Buytters(b_comment));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("buyeetList", buyeetList);
		}

	//
	// nice buyボタン押された時の処理
			if (request.getParameter("Submit").equals("nice buy!!")) {
		System.out.println("139さん");

				// リクエストパラメータを取得する
				String buyte_id = request.getParameter("Submit2");
		System.out.println("idは" + buyte_id);

				// nicebuyDAOのオブジェクト宣言
				nicebuyDAO objDao = new nicebuyDAO();
				if(objDao.insert(new Nicebuy(buyte_id))) {
					System.out.println("成功");
				}
				else {
					System.out.println("失敗");
				}

				// TL画面と同じ処理
				// buytterDAOのオブジェクト宣言
				buytterDAO objDao2 = new buytterDAO();

				  List<Buytters> buyeetList= objDao2.select();

				  // 並び変えた投稿をリクエストスコープに格納する
				  request.setAttribute("buyeetList", buyeetList);
			}


		// 処理が終わったらTL画面にフォワードする
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/buytter.jsp");
			    dispatcher.forward(request, response);

	}
}
