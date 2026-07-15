package control;

import java.io.IOException;

import action.CustomerSearchAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class KiddaLaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		
		// commandの値がない場合はメインメニューに遷移する
		if (command == null || command.isEmpty()) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		switch (command) {
		case "CustomerSearchDisplay":
			RequestDispatcher dis = request.getRequestDispatcher("CustomerSearch.jsp");
			dis.forward(request, response);
			break;
			
		case "CustomerSearch":
			try {
				String[] data = { request.getParameter("tel"), request.getParameter("kana") };
				CustomerSearchAction action = new CustomerSearchAction();
				String[][] result = action.execute(data);
				request.setAttribute("result", result);
				request.getRequestDispatcher("CustomerSearch.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
			break;
			
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;

		}
	}

}
