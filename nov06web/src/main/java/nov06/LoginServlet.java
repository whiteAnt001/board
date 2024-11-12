package nov06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String password = request.getParameter("PWD");
		LoginDAO dao = new LoginDAO();
		boolean result = dao.login(id, password);
		String loginSuccess = "FAIL";
		if(result) {//로그인 성공
			loginSuccess = "OK";
			HttpSession session = request.getSession();//HttpSession 인스턴스 생성
			session.setAttribute("USER", id);//HttpSession 객체에 계정을 저장한다.
		}else {//로그인 실패
			
		}
		response.sendRedirect("loginResult.jsp?LOGIN="+loginSuccess);
	}

}

class OracleXE11g{
    static final String LIB = "oracle.jdbc.driver.OracleDriver"; //상수처리
    static final String NAME = "Jdbc:oracle:thin:@localhost:1521:XE"; //상수처리
 }

class LoginDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	boolean yesOrNo;
	
	String query = "select user_id from user_info where user_id=? and user_pwd=?";
	boolean login(String id, String pwd) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) { //조회 결과가 존재하는 경우, 즉 로그인 성공
				yesOrNo = true;	
			}
		}catch (Exception e) {
			System.out.println("DB작업 중 문제발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return yesOrNo;
	}
}