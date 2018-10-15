package tk.patrickweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.patrickweb.dao.InstallDao;

/**
 * Servlet implementation class InstallServlet
 */
@WebServlet("/install")
public class InstallServlet extends HttpServlet {
	private InstallDao installDao = new InstallDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info;
		try {
			if(installDao.getInstall() == true) {
				info = "O Banco de Dados já foi configurado!";
			}else {
				info = "O Banco de Dados foi instalado com sucesso!";
			}
			request.setAttribute("install", info);
		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		}
		catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/install.jsp");
		dispatcher.forward(request, response);
	}
}
