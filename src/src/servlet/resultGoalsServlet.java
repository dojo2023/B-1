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
import dao.buytterDAO;
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
 * Servlet implementation class resultGoalsServlet
 */
@WebServlet("/resultGoalsServlet")
public class resultGoalsServlet extends HttpServlet {
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

			//目標達成、失敗　テキストと画像を取り出す
			banksDAO bd = new banksDAO ();

			int ggoal = gd.getggoal(userid);
			int bbank = bd.getbbank(userid);

			int gratio = bbank / ggoal;

			String result;

			if(gratio == 100){
				String result ="目標達成"
			}
			else{
				String result ="目標失敗"
			}

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/resultGoals.jsp");
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
