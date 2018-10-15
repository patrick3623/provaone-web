package tk.patrickweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tk.patrickweb.model.Acess;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/sessao")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String name = (String) session.getAttribute("name");
			String email = (String) session.getAttribute("email");
			Acess acess = (Acess) session.getAttribute("acess");
			Integer time = session.getMaxInactiveInterval();
			System.out.println("Nome: " + name + " Email: " + email + " Acess id: " + acess.getId() + " Acess Nome: " + acess.getName() + " Acess Nível: " + acess.getLevel() + " Time SEC: " + time);
		} catch (Exception e) {
			System.out.println("Desculpe Nenhuma Sessão pode ser recuperada!");
		}
	}
}
