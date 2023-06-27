package servlet;

import java.io.IOException;

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
import dao.paymentsDAO;
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

		System.out.println("resultG：userid:"+userid);
			//目標達成、失敗　テキストを取り出す
			banksDAO bnkDAO = new banksDAO();
			goalsDAO gDAO = new goalsDAO();

			int goals = gDAO.select(userid);
			System.out.println("resultG：48");

			int banks = bnkDAO.select(userid);
			System.out.println("resultG：51");

			int gratio = banks / goals * 100;

			//目標成功、失敗　画像を取り出す
			charpicsDAO cd = new charpicsDAO ();

			int b =cd.health(userid);
			String c_name = cd.pic(b, userid);

			String result;

			System.out.println("gratio:"+gratio);
			if(gratio >= 100){
				 result ="目標達成";
			}
			else{
				 result ="目標失敗";
				 c_name = "Ifrit＿grave.png";
			}
			//リクエストスコープ
			request.setAttribute("result",result);

			//リクエストスコープ
			request.setAttribute("c_name",c_name);

			//ヘルス削除
			healthsDAO hd = new healthsDAO();
			if(hd.delete(userid)) {
				System.out.println("ヘルス削除");
			}
			System.out.println("ヘルス削除失敗");

			//ペイメント削除
			paymentsDAO pd = new paymentsDAO();
			if(pd.delete(userid)){
				System.out.println("payment削除");
			}
			System.out.println("paymetn削除go");

			//goals削除
			if(gDAO.delete(userid)){
				System.out.println("goals削除");
			}
			System.out.println("goals削除go");


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
