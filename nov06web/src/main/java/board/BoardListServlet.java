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
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardListDAO dao = new BoardListDAO();
		ArrayList<BoardDTO> al = dao.doIt();
		request.setAttribute("BOARD", al);
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class BoardListDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> al;
	
	String query = "select id, title, content, to_char(write_date, 'YYYY/MM/DD HH24:MI:SS') from free_board";
	
	ArrayList<BoardDTO> doIt(){
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			al = new ArrayList<BoardDTO>();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setWriter(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setWrite_date(rs.getString(4));
				al.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시글 목록 검색 중 문제발생");
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
