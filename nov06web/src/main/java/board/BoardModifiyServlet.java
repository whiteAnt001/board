package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.OpenSSLUtil;

/**
 * Servlet implementation class BoardModifiyServlet
 */
@WebServlet("/boardModifiy.do")
public class BoardModifiyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModifiyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); //소문자로 적어야 한다.
		String btn = request.getParameter("BTN");//버튼의 NAME이 들어있는 파라미터를 수신한다.
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		if(btn.equals("수정")) {
			BoardModifiyDAO dao = new BoardModifiyDAO();
			boolean result = dao.doIt(title, content);
			if(result) {//update가 성공한 경우
				response.sendRedirect("boardList.do");
			}else { //update가 실패한 경우
				
			}	
		}else if(btn.equals("삭제")) {
			System.out.println("삭제를 수행합니다.");
			BoardDeleteDAO dao = new BoardDeleteDAO();
			boolean result = dao.doIt(title);
			if(result) { // delete가 성공한 경우
				response.sendRedirect("boardList.do");
			}else { // delete가 실패한 경우
				
			}
		}
	}
}
class BoardDeleteDAO {
	Connection con;
	PreparedStatement pstmt;
	boolean yesOrNo;
	
	String query = "delete from free_board where title = ?";
	boolean doIt(String title) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.executeUpdate();
			yesOrNo = true;
		} catch (Exception e) {
			System.out.println("게시글 삭제작업 중 문제발생");
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
class BoardModifiyDAO {
	Connection con;
	PreparedStatement pstmt;
	boolean yesOrNo;
	
	String query = "update free_board set content = ? where title = ?"; //free_board 테이블의 content를 변경
	
	boolean doIt(String title, String content) {
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setString(2, title);
			pstmt.executeUpdate(); // Update를 실행
			yesOrNo = true; // update시 문제가 없을경우 true로 변경
		} catch (Exception e) {
			System.out.println("게시글 수정 중 오류발생");
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
