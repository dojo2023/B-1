package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import model.Result;
import model.SetGoals;
/**
 * Servlet implementation class setGoalsServlet
 */
@WebServlet("/setGoalsServlet")
public class setGoalsServlet extends HttpServlet {
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


		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/setGoals.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doPost(request, response);
		//sessionスコープnullなら
	    HttpSession session = request.getSession();
	    if (session.getAttribute("userid") == null) {
		    response.sendRedirect("/Ifrit/loginServlet");
			return;
	    }


	request.setCharacterEncoding("UTF-8");
	//useridを取得
	String userid = (String) session.getAttribute("userid");
	// リクエストパラメータを取得する
	String goal = request.getParameter("ggoal");
	int ggoal = Integer.parseInt(goal);

	String available = request.getParameter("gavailable");
	int gavailable  = Integer.parseInt(available);

	String limit = request.getParameter("glimit");

	String want = request.getParameter("gwant");

	String cname = request.getParameter("cname");


	// 登録処理を行う
	goalsDAO gd =  new goalsDAO();
//	boolean check = gd.setGoal(new Goals(ggoal,gavailable,limit,want));
//
//	if(check) {
//		System.out.println("setGoal成功");
//	}else {
//		System.out.println("setGoal失敗");
//	}

	// データを格納
	if (gd.setGoal(new SetGoals(ggoal,limit,want,cname,userid,gavailable))){	// 登録成功
		request.setAttribute("result",
		new Result("登録成功！", "/Ifrit/eggServlet"));
		System.out.println("登録成功");
	}
	else{												// 登録失敗
		request.setAttribute("result",
		new Result("登録失敗！", "/Ifrit/setGoalsServlet"));
		System.out.println("登録失敗");
	}

	// 結果ページにフォワードする
		RequestDispatcher dispatcher =
			request.getRequestDispatcher
				("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
}
