package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.User_CreateDAO;
import model.entity.User;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserCreate.jsp");
		re.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//CreateUserから送られたid、password、name、mailをString化
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");

		System.out.println(id + "/" + password + "/" + name + "/" + mail);
		System.out.println(id.length());
		System.out.println(password.length());

		//id、passwordがDB定義から外れていたらエラーを返す
		if (id.length() > 10 || id.length() == 0 || password.length() > 8 || password.length() == 0) {
			RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserCreate_NG.jsp");
			re.forward(request, response);
		} else {
			//すべて正常に入力されていたらDAO処理
			User createuser = new User(id, password, name, mail);
			User_CreateDAO dao = new User_CreateDAO();
			boolean make_user = dao.CreateUser(createuser);

			//DAO結果をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("make_user", make_user);

			//成功ページ
			RequestDispatcher re = request.getRequestDispatcher("WEB-INF/accountjsp/UserCreate_OK.jsp");
			re.forward(request, response);

		}

	}

}
