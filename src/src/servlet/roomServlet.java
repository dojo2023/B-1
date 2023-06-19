package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import model.LoginUser;
import model.Calendar;
import model.CalendarDate;
import model.Room;
import model.Achievement;
import model.Ranking;
import model.ResultGoals;
import model.Character;
import model.PictureBook;
import model.Result;
import model.DressUp;
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
		goalsDao gd = new goalsDao ();
		
		String cname = gd.getcname(userid);

		//目標達成度を取り出す
		banksDao bd = new banksDao ();

		int ggoal = gd.getggoal(userid);
		int bbank = bd.getbbank(userid);

		int gratio = bbank / ggoal 

		//出会って何日目を取り出す

		Timestamp updateat = gd.getupdateat(userid);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");

		// 現在日時を取得
  		Timestamp timestamp = new Timestamp(updateat);

		// Date型へ変換
  		Date date2 = new Date(timestamp.getTime());

		Date meet = date2 - updateat

		//状態を取り出す
		healthsDao hd = new healthsDao ();

		int healthpm = hd.gethealthpm(userid);

		String health; 
		
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
		//コメントを取り出す
		Random rand = new Randam();
		int num = rand.nextInt(10) + 100;

		String comment;

		switch (num) {
			case 0: 
			num = "今日も一日頑張ろうね！";
			break;
			case 1:
			num = "上手くお金管理できてて偉い！";
			break;
			case 2:
			num = "たまには休憩も必要だね！";
			break;
			case 3:
			num = "ご褒美もたまには必要！";
			break;
			case 4: 
			num = "頑張りすぎないようにね！";
			break;
			case 5:
			num = "たくさんお金を貯めて欲しいものを買おう！";
			break;
			case 6:
			num = "毎日ログインすれば、ポイントも貯まる！";
			break;
			case 7:
			num = "節約した分だけ得した気分になれると思うよ！";
			break;
			case 8: 
			num = "健康第一！";
			break;
			case 9:
			num = "喋る前に飲む。";
			break;

		}



		
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
