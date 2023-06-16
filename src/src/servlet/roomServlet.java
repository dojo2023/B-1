package servlet;

import java.io.IOException;

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
import model.Calendar;
import model.CalendarDate;
import model.Room;
import model.achievement;
import model.Ranking;
import model.ResultGoals;
import model.Character;
import model.PictuerBook;
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
