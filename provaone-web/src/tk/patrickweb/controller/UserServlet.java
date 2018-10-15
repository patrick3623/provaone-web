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
import tk.patrickweb.dao.UserDao;
import tk.patrickweb.model.Acess;
import tk.patrickweb.model.User;
import tk.patrickweb.util.Sha256Generator;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/usuarios")
public class UserServlet extends HttpServlet {
	private AcessDao acessDao = new AcessDao();
	private UserDao userDao = new UserDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean isLoggedIn = (Boolean) request.getSession().getAttribute("isLoggedIn");
		if (isLoggedIn != null) {
			String action = request.getParameter("action");
			try {
				if (action != null) {
					if (action.equals("excluir")) {
						Integer id = Integer.parseInt(request.getParameter("id"));
						userDao.excluir(id);
						request.setAttribute("error", "Usuário Excluido Com Sucesso.");
					} else if (action.equals("editar")) {
						Integer id = Integer.parseInt(request.getParameter("id"));
						User user = userDao.getUserId(id);
						if (user != null) {
							request.setAttribute("form", user);
						} else {
							request.setAttribute("error", "Nenhum Usuário Encontrado Com Esse Id.");
						}
						request.setAttribute("error", "Usuário Editado Com Sucesso.");
					}

				}
				request.setAttribute("acesses", acessDao.getAcess());
				request.setAttribute("users", userDao.getUser());
				request.setAttribute("isLoggedIn", isLoggedIn);
			} catch (SQLException e) {
				request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
			} catch (ClassNotFoundException e) {
				request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user.jsp");
			dispatcher.forward(request, response);
		} else {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Sha256Generator sha256Password = new Sha256Generator();
		password = sha256Password.generate(password);
		Integer id_acess = Integer.parseInt(request.getParameter("id_acess"));
		System.out.println(name + email + password + " ID: " + id_acess);
		Acess acess = new Acess(id_acess);
		User user = new User(null, name, email, password, acess);
		try {
			userDao.save(user);
			request.setAttribute("accesses", acessDao.getAcess());
			request.setAttribute("error", "Usuário Cadastrado Com Sucesso.");
			request.setAttribute("users", userDao.getUser());

		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/status/user.jsp");
		dispatcher.forward(request, response);
	}

}
