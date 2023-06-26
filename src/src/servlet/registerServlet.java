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
import model.Idpws;
import model.Result;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest request,
		      HttpServletResponse response)
		      throws ServletException, IOException {

//			goalsDAO gd = new goalsDAO();
//			Timestamp gCreate = gd.getCreate("aa");
//			SimpleDateFormat daykata = new SimpleDateFormat("yyyy-MM-dd");
//			String goal_created = daykata.format(gCreate);
//			System.out.println("goal::"+goal_created);

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/register.jsp");
		    dispatcher.forward(request, response);
		  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String userid = request.getParameter("userid");
				String userpw = request.getParameter("userpw");
				String username = request.getParameter("username");
				System.out.println("げっとぱらめーた");
				idpwsDAO iDao = new idpwsDAO();

				if (iDao.register(new Idpws(userid,userpw,username))) {	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "/Ifrit/setGoalsServlet"));
					System.out.println("登録成功");
				}
				else{												// 登録失敗
					request.setAttribute("result",
					new Result("登録失敗！", "/Ifrit/loginServlet"));
					System.out.println("登録失敗");
				}
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
				System.out.println("ふぉわーど");
	}

}
