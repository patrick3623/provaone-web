package tk.patrickweb.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.patrickweb.dao.RecordDao;
import tk.patrickweb.dao.UserDao;
import tk.patrickweb.model.Record;
import tk.patrickweb.model.User;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/registros")
public class RecordServlet extends HttpServlet {
	RecordDao recordDao = new RecordDao();
	UserDao userDao = new UserDao();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecordServlet() {
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
						recordDao.excluir(id);
						request.setAttribute("error", "Registro Excluido Com Sucesso.");
					} else if (action.equals("editar")) {
						Integer id = Integer.parseInt(request.getParameter("id"));
						Record record = recordDao.getRecordId(id);
						if (record != null) {
							request.setAttribute("form", record);
						} else {
							request.setAttribute("error", "Nenhum Registro Encontrado Com Esse Id.");
						}
						request.setAttribute("error", "Usuário Editado Com Sucesso.");
					}
				}
				request.setAttribute("users", userDao.getUser());
				request.setAttribute("records", recordDao.getRecord());
				request.setAttribute("isLoggedIn", isLoggedIn);
			} catch (SQLException e) {
				request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
			} catch (ClassNotFoundException e) {
				request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/record.jsp");
			dispatcher.forward(request, response);
		}
		else{
			response.sendRedirect("/provaone-web/login"); 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date = request.getParameter("date");
		String note = request.getParameter("note");
		Integer id_user = Integer.parseInt(request.getParameter("id_user"));
		System.out.println(date + note + " ID: " + id_user);
		User user = new User(id_user, null, null);
		Record record = new Record(null, date, note, user);
		try {
			recordDao.save(record);
			request.setAttribute("records", recordDao.getRecord());
			request.setAttribute("users", userDao.getUser());
			request.setAttribute("error", "Ponto Registrado Com Sucesso.");
		} catch (SQLException e) {
			request.setAttribute("error", "Error in DB Connect: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("error", "Error in jdbc Driver: " + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/status/record.jsp");
		dispatcher.forward(request, response);
	}

}
