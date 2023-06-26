package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import dao.idpwsDAO;
import dao.pointsDAO;
import model.Idpws;

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータを取得する （入力された値を受け取り、変数に格納する）
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");

		// ログイン処理を行う （SQLを動作させるDAO）
		idpwsDAO iDao = new idpwsDAO(); //インスタンス化したもの
		//ログインポイント付与用
		pointsDAO pd =  new pointsDAO();
		if (iDao.isLoginOK(new Idpws(userid, userpw))) { // ログイン成功

			// セッションスコープにuseridを格納する
			HttpSession session = request.getSession();
//			session.setAttribute("userid",new LoginUser(userid));
			session.setAttribute("userid", userid);

			//目標期間をすぎているか否か
			try {
				Date nowday = new Date();
				goalsDAO gd = new goalsDAO();
				String created = gd.getlimit(userid);
				String sdaypm = created.replace("-", "/");
				System.out.println("送られてきた値" + sdaypm);
				System.out.println("58");
				Date limitday = DateFormat.getDateInstance().parse(sdaypm);
				if (nowday.after(limitday)) {
					// カレンダーサーブレットにリダイレクトする
					response.sendRedirect("/Ifrit/resultGoalsServlet");
				} else {
					response.sendRedirect("/Ifrit/calendarServlet");
				}
			//ログインポイント１５０ポイント
			if(pd.loginP(userid)) {
				System.out.println("ログインポイント成功");
			}else {
				System.out.println("ログインポイント失敗");
			}

//			//ログイン履歴
//			loginsDAO lgd = new loginsDAO();
//			if(lgd.insert(userid)){
//				System.out.println("ログインポイント成功");
//			}else {
//				System.out.println("ログインポイント失敗");
//			}
//			Timestamp gCreate = gd.getCreate(userid);
//			SimpleDateFormat daykata = new SimpleDateFormat("yyyy-MM-dd");
//			String goal_created = daykata.format(gCreate);
//			System.out.println("goal::"+goal_created);
//			//取得した目標設定日をDate型にする。
//
//			lgd.c_login(userid,goal_created);

			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		}

	}
}