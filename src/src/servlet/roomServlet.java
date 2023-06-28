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
import dao.charpicsDAO;
import dao.goalsDAO;
import dao.healthsDAO;
import dao.pointsDAO;

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
		request.setCharacterEncoding("UTF-8");

		System.out.println("43");
		//キャラクター名を取り出す
		goalsDAO gd = new goalsDAO ();

		String cname = gd.getcname(userid);
		System.out.println("cnameさんは" + cname);

		// リクエストスコープに格納するよ
		request.setAttribute("cname",cname);

		//キャラ画像の表示
		charpicsDAO cd = new charpicsDAO ();

		int b =cd.health(userid);
		String c_name = cd.pic(b, userid);

		// リクエストスコープに格納するよ
		request.setAttribute("c_name",c_name);

		//目標達成度を取り出す
		banksDAO bankDAO = new banksDAO ();

		int goals = gd.select(userid);
		System.out.println(goals);
		int banks = bankDAO.select(userid);
		System.out.println("banks");

		int gratio = banks / goals * 100;

		if(gratio >= 100) {
			gratio = 100;
		}

		// リクエストスコープに格納するよ
		request.setAttribute("gratio",gratio);




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
		System.out.println("gdateさんは" +gdate);
		System.out.println("ndateさんは" +ndate);

		long daysa = (ndate - gdate) / oneday;
		System.out.println("76");
		int myInt = Math.toIntExact(daysa);
		System.out.println("78");
		System.out.println("myInt");
		Integer myint = new Integer(myInt);
		request.setAttribute("meet", myint);

		//状態を取り出す
		healthsDAO hd = new healthsDAO ();

		int healthpm = hd.he(userid);
		System.out.println("healthpm]]"+healthpm);


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
		//ポイント表示

		pointsDAO pd = new pointsDAO();
		int char_point = pd.select(userid);
		request.setAttribute("point_pm", char_point);


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
//		doGet(request, response);
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("/Ifrit/loginServlet");
			return;
		}
		request.setCharacterEncoding("UTF-8");

		//セッションスコープにあるuseridを取得
		String userid = (String)session.getAttribute("userid");
		//pointdao
		pointsDAO pd = new pointsDAO();
		//health_pm
		healthsDAO hd = new healthsDAO();
		//病気を治すボタンの処理。
		System.out.println("ボタン押したとき"+request.getParameter("submit"));
		if (request.getParameter("submit").equals("回復")) {
			if(hd.he(userid) != 0) {
				pd.healP(userid);
				System.out.println("healP::");
				hd.heal(userid);
				System.out.println("healHH::");
			}


		}
		doGet(request, response);
	}

}
