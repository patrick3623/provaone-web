package tk.patrickweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.patrickweb.dao.AcessDao;
import tk.patrickweb.model.Acess;

/**
 * Servlet implementation class AcessServlet
 */
@WebServlet("/niveisdeacesso")
public class AcessServlet extends HttpServlet {
	private AcessDao acessDao = new AcessDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcessServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean isLoggedIn = (Boolean)request.getSession().getAttribute("isLoggedIn");
		if(isLoggedIn != null){
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if (action.equals("excluir")) {
					Integer id = Integer.parseInt(request.getParameter("id"));
					acessDao.excluir(id);
					request.setAttribute("error", "Registro Excluido Com Sucesso.");
				} else if (action.equals("editar")) {
					Integer id = Integer.parseInt(request.getParameter("id"));
					Acess acess = acessDao.getAcessId(id);
					if (acess != null) {
						request.setAttribute("form", acess);
					} else {
						request.setAttribute("error", "Nenhum Nível de Acesso Encontrado Com Esse Id.");
					}
					request.setAttribute("error", "Nível de Acesso Editado Com Sucesso.");
				}
			}
			request.setAttribute("accesses", acessDao.getAcess());
			request.setAttribute("isLoggedIn", isLoggedIn);
		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/acess.jsp");
		dispatcher.forward(request, response);
		}else{
			response.sendRedirect("/provaone-web/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Integer level = Integer.parseInt(request.getParameter("level"));
		Acess acess = new Acess(null, name, level);

		try {
			acessDao.save(acess);
			request.setAttribute("error", "Nivel De Acesso Cadastrado Com Sucesso.");
			request.setAttribute("accesses", acessDao.getAcess());

		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/acess.jsp");
		dispatcher.forward(request, response);
	}

}
