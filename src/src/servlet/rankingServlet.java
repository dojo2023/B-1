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

import model.Ranking;

/**
 * Servlet implementation class rankingServlet
 */
@WebServlet("/rankingServlet")
public class rankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//ログインせずに直接来たら、ログイン画面に戻す処理
		//↓HttpSessionはここで使ったら37行目のとこでは使わないでね！
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/Ifrit/loginServlet");
			return;
		}
		//セッションスコープにあるuseridを取得
		String userid = (String) session.getAttribute("userid");

		//ポイント上位の５人のuseridとポイントをとりだす。
		pointsDao pd = new pointsDao();
		List<Ranking> rankList = pd.rankList();
		//while分で（next）がtrueのときに降順で取り出したuseridをもとに下記の項目を取り出す。
		//ユーザ名取り出す
		idpwsDao ipd = new idpwsDao();
		//ポイントを取り出す。
		pointsDao pd = new pointsDao();
		//画像を取り出す。
		charpicsDao cd = new charpicsDao();
		//rankListに格納するために、ポイントをSUMして降順でuseridをTOP５まで取り出して
		//そのuseridをもとに、ユーザ名、キャラID取得してキャラ画像を取得。リストに格納。


		request.setAttribute("rankList", rankList);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ranking.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
