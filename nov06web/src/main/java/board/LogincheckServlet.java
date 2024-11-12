package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck.do")
public class LogincheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogincheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		String jsp = "";
		if(id == null) { //로그인을 한 경우
			jsp = "login.jsp";
		}else { // 로그인을 안 한 경우
			jsp = "write_board.jsp";
		}
		response.sendRedirect(jsp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
