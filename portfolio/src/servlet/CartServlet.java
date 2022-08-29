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

import model.dao.Cosme_SelectCosmeDAO;
import model.entity.Cosme;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
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

		request.setCharacterEncoding("UTF-8");

		//パラメータを変数化
		String code = request.getParameter("code");
		System.out.println("飛んできたコードは" + code);

		Cosme cosme = new Cosme(code);
		//カート(初回)
		ArrayList<Cosme> list_cart = new ArrayList<Cosme>();
		Cosme cosme_buy;

		//変数をもとにDAO呼び出し
		Cosme_SelectCosmeDAO dao = new Cosme_SelectCosmeDAO();
		cosme_buy = dao.findCosme(cosme);
		list_cart.add(cosme_buy);

		//coslistをセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("list_cart", list_cart);

		System.out.println(list_cart);

		RequestDispatcher re = request.getRequestDispatcher("WEB-INF/menujsp/Cartlist.jsp");
		re.forward(request, response);

	}
}
