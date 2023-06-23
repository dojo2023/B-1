package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java. util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.banksDAO;
import dao.goalsDAO;
import dao.healthsDAO;

/**
 * Servlet implementation class roomServlet
 */
@WebServlet("/roomServlet")
public class roomServlet extends HttpServlet {
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
		//セッションスコープにあるuseridを取得
		String userid = (String)session.getAttribute("userid");

		//キャラクター名を取り出す
		goalsDAO gd = new goalsDAO ();

		String cname = gd.getcname(userid);

		//目標達成度を取り出す
		banksDAO bankDAO = new banksDAO ();

		int goals = gd.select(userid);
		int banks = bnkDAO.select(userid);

		int gratio = banks / goals * 100;






		//出会って何日目を取り出す

		Timestamp createdat = gd.getupdateat(userid);
		Date date = new Date();

		// Date型へ変換
  		Date date2 = new Date(createdat.getTime());

		long ndate =date.getTime();
		System.out.println("70");
		long gdate = date2.getTime();
		System.out.println("72");
		long oneday = 1000 * 60 * 60 * 24;
		System.out.println("74");
		long daysa = (gdate - ndate) / oneday;
		System.out.println("76");
		int myInt = Math.toIntExact(daysa);
		System.out.println("78");
		System.out.println("myInt");
		Integer myint = new Integer(myInt);
		request.setAttribute("meet", myint);

		//状態を取り出す
		healthsDAO hd = new healthsDAO ();

		int healthpm = hd.gethealthpm(userid);

		String health = null;

		switch (healthpm) {
			case 0:
			health = "健康";
			break;
			case 1:
			health = "高熱";
			break;
			case 2:
			health = "重体";
			break;
			case 3:
			health = "絶命寸前";
			break;
		}
		request.setAttribute("health",health);

		//コメントを取り出す
		Random rand = new Random();
		int num = rand.nextInt(10);

		String comment = null;
		System.out.println("南無阿弥陀仏" + num);

		switch (num) {
			case 0:
			comment = "今日も一日頑張ろうね！";
			break;
			case 1:
			comment = "上手くお金管理できてて偉い！";
			break;
			case 2:
			comment = "たまには休憩も必要だね！";
			break;
			case 3:
			comment = "ご褒美もたまには必要！";
			break;
			case 4:
			comment = "頑張りすぎないようにね！";
			break;
			case 5:
			comment = "たくさんお金を貯めて欲しいものを買おう！";
			break;
			case 6:
			comment = "毎日ログインすれば、ポイントも貯まる！";
			break;
			case 7:
			comment = "節約した分だけ得した気分になれると思うよ！";
			break;
			case 8:
			comment = "健康第一！";
			break;
			case 9:
			comment = "喋る前に飲む。";
			break;

		}
		request.setAttribute("comment", comment);


		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/room.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
