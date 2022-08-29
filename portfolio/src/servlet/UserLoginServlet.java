package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.User_LoginDAO;
import model.entity.Cosme;
import model.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//index.jspから指示されたページに飛ばす
		RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserLogin.jsp");
		re.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//Login.jspから送られたid、passwordをString化
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		System.out.println(id + password);

		//id、passwordをuseraccountに格納しLoginlogicを通してDB照合
		//ログイン可否によってそれぞれのページに飛ばす
		User useraccount = new User(id, password);
		//変数をもとにDAO呼び出し
		User_LoginDAO dao = new User_LoginDAO();
		useraccount = dao.findByLogin(useraccount);

		//DAO結果をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("useraccount", useraccount);
		
		//カート作成
		ArrayList<Cosme> cartlist = new ArrayList<Cosme>();
		session.setAttribute("cartlist", cartlist);

		if (useraccount != null) {
			RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserLogin_OK.jsp");
			re.forward(request, response);
		} else {
			RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserLogin_NG.jsp");
			re.forward(request, response);
		}

	}

}
