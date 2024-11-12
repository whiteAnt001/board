package board;

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

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("TITLE");
		System.out.println(title);
		BoardDetailDAO dao = new BoardDetailDAO();
		BoardDTO dto = dao.doIt(title);
		request.setAttribute("DTO", dto);
		RequestDispatcher rd = request.getRequestDispatcher("boardDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class BoardDetailDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	BoardDTO dto;
	
	String query="select id,title,content,to_char(write_date,'YYYY/MM/DD HH24:MI:SS') "
			+ "from free_board where title = ?";
	
	BoardDTO doIt(String title){
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			rs.next();
			dto = new BoardDTO();
			dto.setWriter(rs.getString(1));
			dto.setTitle(rs.getString(2));
			dto.setContent(rs.getString(3));
			dto.setWrite_date(rs.getString(4));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 조회 중 오류발생");
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
}