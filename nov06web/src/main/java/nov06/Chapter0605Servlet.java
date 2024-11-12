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

@WebServlet("/chapter0605.do")
public class Chapter0605Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Chapter0605Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		if(id == null) { //로그인을 안 한 경우
			response.sendRedirect("login.jsp");
		}else {
			String name = request.getParameter("NAME");
			Chapter0605DAO dao = new Chapter0605DAO();
			ArrayList<Chapter0605DTO> al = dao.doIt(name);
			
			request.setAttribute("AL", al);
			RequestDispatcher rd= request.getRequestDispatcher("chapter0605Result.jsp");
			rd.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

class Chapter0605DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Chapter0605DTO> al;
	
	String query = "select last_name, salary from employees "
			+ "where manager_id in (select employee_id from employees where last_name = ?)";
	
	ArrayList<Chapter0605DTO> doIt(String name) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			al = new ArrayList<Chapter0605DTO>();
			while(rs.next()) {
				Chapter0605DTO dto = new Chapter0605DTO();
				dto.setName(rs.getString(1));
				dto.setSalary(rs.getString(2));
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
