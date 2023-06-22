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

import dao.charpicsDAO;
import dao.pointsDAO;
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
		int yout=0;
		int pointt = 0;
		int rankt = 1;
		//ポイント上位の５人のuseridとポイントをとりだす。
		pointsDAO pd = new pointsDAO();
		System.out.println("43");
		List<Ranking> rankList = pd.rankList();
		System.out.println("45");
		//while分で（next）がtrueのときに降順で取り出したuseridをもとに下記の項目を取り出す。
		//ユーザ名取り出す
		//ポイントを取り出す。
		//画像を取り出す。
		System.out.println(rankList.get(0));
		System.out.println(rankList.get(1));
		charpicsDAO cd = new charpicsDAO();
		System.out.println("51");
		for(int i = 0;rankList.size()>i;i++) {
			System.out.println("53");
			Ranking rank = rankList.get(i);
			System.out.println("55");
			String username = rank.getUsername();
			System.out.println("username"+username);
			System.out.println("userid:"+userid);

			if(username.equals(userid)) {
				yout = i+1;
				System.out.println("namae"+yout);
				pointt=pd.select(userid);
				System.out.println("pointt"+pointt);
			}
			System.out.println("57");
			int b =cd.health(username);
			String c = cd.pic(b, username);
			rank.setPic(c);
			System.out.println("pic:"+c);
			System.out.println("59");
			rankList.set(i, rank);
			System.out.println("61");
		}

		//rankListに格納するために、ポイントをSUMして降順でuseridをTOP５まで取り出して
		//そのuseridをもとに、ユーザ名、キャラID取得してキャラ画像を取得。リストに格納。

		Integer you = new Integer(yout);
		Integer point = new Integer(pointt);
		Integer rankk = new Integer(rankt);
		request.setAttribute("rankList", rankList);
		request.setAttribute("you", you);
		request.setAttribute("point", point);
		request.setAttribute("rank", rankk);


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
