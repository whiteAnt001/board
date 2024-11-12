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

@WebServlet("/chapter0604.do")
public class Chapter0604Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Chapter0604Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept_id = request.getParameter("dept_id");
		Chapter0604DAO dao = new Chapter0604DAO();
		ArrayList<Chapter0604DTO> al = dao.doIt(dept_id);
		System.out.println(dept_id);
		
		//배열이기 때문에 forward
		request.setAttribute("AL", al);
		RequestDispatcher rd = request.getRequestDispatcher("chapter0604Result.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class Chapter0604DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<Chapter0604DTO> al;
	
	String query = "select last_name, department_id, job_id "
			+ "from employees where department_id "
			+ "in (select department_id from departments where location_id = ?)";
	
	ArrayList<Chapter0604DTO> doIt(String dept_id) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(dept_id));
			rs = pstmt.executeQuery();
			al = new ArrayList<Chapter0604DTO>();
			while(rs.next()) {
				Chapter0604DTO dto = new Chapter0604DTO();
				dto.setName(rs.getString(1));
				dto.setDept_id(rs.getInt(2));
				dto.setJob_id(rs.getString(3));
				al.add(dto);
			}
		} catch (Exception e) {
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
