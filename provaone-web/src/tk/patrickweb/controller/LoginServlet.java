package tk.patrickweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.patrickweb.dao.UserDao;
import tk.patrickweb.model.User;
import tk.patrickweb.util.Sha256Generator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	UserDao userDao = new UserDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Sha256Generator sha256Password = new Sha256Generator();
		password = sha256Password.generate(password);
		try {
			User user = userDao.getLogin(email, password);
			if(user != null) {
				request.setAttribute("error", "Conectado com sucesso!");
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getName());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("acess", user.getAcess());
				session.setAttribute("isLoggedIn", true);
				session.setMaxInactiveInterval(900);
			}else {
				request.setAttribute("error", "Usuário ou senha inválidos!");
			}
		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
		response.sendRedirect("/provaone-web"); 
	}

}
