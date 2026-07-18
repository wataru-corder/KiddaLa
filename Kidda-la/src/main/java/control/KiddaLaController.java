package control;

import java.io.IOException;

import action.CustomerSearchAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/KiddaLaController")
public class KiddaLaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String E010 = "【エラー】DB接続処理に失敗しました！管理者に連絡してください。";
	public static final String E011 = "【エラー】電話番号と氏名カナのいずれか、または両方を入力してください。";
	public static final String W012 = "【確認】一致する情報は見つかりませんでした。";
	public static final String E013 = "【エラー】顧客情報検索処理に失敗しました！管理者に連絡してください。";

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
			RequestDispatcher dis = request.getRequestDispatcher("customerSearch.jsp");
			dis.forward(request, response);
			break;

		case "CustomerSearch":
			try {
				String tel = request.getParameter("tel");
				String kana = request.getParameter("kana");
				// 入力チェック：両方未入力（メッセージ011）
				if ((tel == null || tel.isEmpty()) && (kana == null || kana.isEmpty())) {
					request.setAttribute("message", E011);
					request.getRequestDispatcher("customerSearch.jsp").forward(request, response);
					return;
				}

				String[] data = { tel, kana };
				CustomerSearchAction action = new CustomerSearchAction();
				String[][] result = action.execute(data);

				if (result != null) {
					request.setAttribute("result", result);
				} else {
					//該当なし（メッセージ012）
					request.setAttribute("message", W012);
				}
				request.getRequestDispatcher("customerSearch.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", E013);
				request.getRequestDispatcher("customerSearch.jsp").forward(request, response);
			}
			break;

		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;

		}
	}

}
