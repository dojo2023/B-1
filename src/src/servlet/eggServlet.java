package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.charactersDAO;
/**
 * Servlet implementation class eggServlet
 */
@WebServlet("/eggServlet")
public class eggServlet extends HttpServlet {
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
			request.setCharacterEncoding("UTF-8");
			//useridを取得
			String userid = (String) session.getAttribute("userid");

			charactersDAO cd = new charactersDAO();
			Random rand = new Random();
			int num = rand.nextInt(3);
			int char_id=0;
			if(num==0) {
				char_id = 1;
			}else if(num == 1) {
				char_id = 2;
			}else if(num == 2) {
//				char_id = 3;
				char_id = 1;
			}
			if(cd.setC(userid,char_id)) {
				System.out.println("卵成功");
			}else {
				System.out.println("卵失敗");

			}

		    // フォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/egg.jsp");
		    dispatcher.forward(request, response);
		  }



}
