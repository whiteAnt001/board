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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WriteBoardServlet
 */
@WebServlet("/writeBoard.do")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//method가 post인 경우 한글처리를 한다.
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("TITLE"); //파라미터 TITLE을 수신한다.
		String content = request.getParameter("CONTENT"); //파라미터 CONTENT를 수신한다.
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USER");
		
		BoardDTO dto = new BoardDTO(); //DTO를 생성
		dto.setWriter(id);
		dto.setTitle(title);
		dto.setContent(content);
		WriteInsertDAO dao = new WriteInsertDAO();
		boolean flag = dao.doIt(dto);//DAO에 게시글 정보가 들어있는 DTO를 넘긴다.
		if(flag) { //게시글 등록 성공
			response.sendRedirect("boardList.do");
		}else { //게시글 등록 실패
			
		}
	}
}
class OracleXE11g{
    static final String LIB = "oracle.jdbc.driver.OracleDriver"; //상수처리
    static final String NAME = "Jdbc:oracle:thin:@localhost:1521:XE"; //상수처리
 }

class WriteInsertDAO {
	Connection con;
	PreparedStatement pstmt;
	
	String query = "insert into free_board values(?, ?, ?, sysdate)";
	boolean doIt(BoardDTO dto) {
		boolean yesOrNo = false;
		try {
			Class.forName(OracleXE11g.LIB);
			con = DriverManager.getConnection(OracleXE11g.NAME, "hr", "hr");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate(); //insert를 실행한다.
			yesOrNo = true; //insert에 문제가 없는 경우
		} catch (Exception e) {
			System.out.println("게시글 삽입 중 문제발생");
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