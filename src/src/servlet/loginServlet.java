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
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
				request.setCharacterEncoding("UTF-8");

				String userid = request.getParameter("userid");
				String userpw = request.getParameter("userpw");

				// ログイン処理を行う （SQLを動作させるDAO）
				idpwsDAO iDao = new idpwsDAO(); //インスタンス化したもの
				if (iDao.isLoginOK(new Idpws(userid, userpw))) {	// ログイン成功

				// セッションスコープにuseridを格納する
				HttpSession session = request.getSession();
				session.setAttribute("userid",new LoginUser(userid));


					// カレンダーサーブレットにリダイレクトする
					response.sendRedirect("/ifrit/calendarServlet");
				}

			}
		}