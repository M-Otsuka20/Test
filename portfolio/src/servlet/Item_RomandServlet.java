package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Cosme_SelectCosmeDAO;
import model.dao.Cosme_SelectMakerDAO;
import model.entity.Cosme;

/**
 * Servlet implementation class RomandServlet
 */
@WebServlet("/Item_RomandServlet")
public class Item_RomandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//パラメータを変数化
		String makercode = request.getParameter("makercode");
		Cosme cosme = new Cosme(makercode);

		//変数をもとにDAO呼び出し
		Cosme_SelectMakerDAO dao = new Cosme_SelectMakerDAO();
		List<Cosme> cosmelist = new ArrayList<Cosme>();
		cosmelist = dao.findCosme(cosme);

		//DAO結果をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("cosmelist", cosmelist);

		//ページ遷移
		RequestDispatcher re = request.getRequestDispatcher("WEB-INF/romandjsp/romand_top.jsp");
		re.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//パラメータを変数化
		String code = request.getParameter("code");

		//変数をもとにDAO呼び出し
		Cosme_SelectCosmeDAO dao = new Cosme_SelectCosmeDAO();
		Cosme pick_cosme = new Cosme(code);
		pick_cosme = dao.findCosme(pick_cosme);

		//DAO結果をセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("pick_cosme", pick_cosme);

		switch (code) {
		case "1":
			RequestDispatcher re = request.getRequestDispatcher("WEB-INF/romandjsp/id1_rip.jsp");
			re.forward(request, response);
			break;

		//case "2":

		}

	}

}
