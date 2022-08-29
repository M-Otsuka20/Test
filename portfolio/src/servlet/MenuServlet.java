package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainmenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字化けしないようにする
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher re = request.getRequestDispatcher("url");

		//Switch分に使うためのkey
		String key = request.getParameter("key");

		switch (key) {
		case "1":
			re = request.getRequestDispatcher("WEB-INF/menujsp/Menu_Brand.jsp");
			re.forward(request, response);
			break;
		case "2":
			re = request.getRequestDispatcher("WEB-INF/menujsp/Menu_Category.jsp");
			re.forward(request, response);
			break;
		}

	}

}
