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

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {

		    // ログインページにフォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");

				String userid = request.getParameter("userid");
				String userpw = request.getParameter("userpw");

				// ログイン処理を行う
				idpwsDAO iDao = new idpwsDAO();
				if (iDao.isLoginOK(new idpws(userid, userpw))) {	// ログイン成功

					// セッションスコープにuseridを格納する
					HttpSession session = request.getSession();
					session.setAttribute("userid",userid);


					// カレンダーサーブレットにリダイレクトする
					response.sendRedirect("/ifrit/calendarServlet");
				}
				else {									// ログイン失敗
					// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
					request.setAttribute("result",
					new Result("ログイン失敗", "IDまたはパスワードに間違いがあります。", "/ifrit/loginServlet"));

					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
					dispatcher.forward(request, response);
				}
			}
		}