package nov06;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Chapter0601Servlet
 */
@WebServlet("/chapter0601.do")
public class Chapter0601Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Chapter0601Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		if(id == null) {// 로그인을 안 한 경우
			response.sendRedirect("login.jsp");
		}else { //로그인을 한 경우
			String name = request.getParameter("NAME");
			Chapter0601DAO dao = new Chapter0601DAO();
			ArrayList<Chapter0601DTO> al = dao.doIt(name);
			System.out.println(name);
			request.setAttribute("AL", al);
			RequestDispatcher rd = request.getRequestDispatcher("chapter0601Result.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class Chapter0601DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Chapter0601DTO> al;
	
	String query ="select last_name, to_char(hire_date, 'YYYY/MM/DD'), department_id "
	         + "from employees where department_id = "
	         + "(select department_id from employees where last_name = ?) "
	         + "and last_name <> ?";
	
	ArrayList<Chapter0601DTO> doIt(String name) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name); // query에 있는 첫 번째 ?에 name에 있는 문자열을 넣는다.
			pstmt.setString(2, name); // query에 있는 두 번째 ?에 name에 있는 문자열을 넣는다.
			rs = pstmt.executeQuery();
			al = new ArrayList<Chapter0601DTO>();
			while(rs.next()) {
				Chapter0601DTO dto = new Chapter0601DTO();
				dto.setName(rs.getString(1));
				dto.setHire_date(rs.getString(2));
				dto.setDept_id(rs.getInt(3));
				al.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB작업 중 문제발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return al;
	}
}