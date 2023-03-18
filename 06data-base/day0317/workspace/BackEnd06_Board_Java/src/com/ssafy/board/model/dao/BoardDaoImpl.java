package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

// 싱글턴으로 만들어보자
public class BoardDaoImpl implements BoardDao {

	// DBUtil 가져와야함.
	// DBUtil이라는 것을 util이라는 이름으로 가져오고 DBUtil이 가지고 있는 getInstance를 통해서 가져온다
	private final DBUtil util = DBUtil.getInstance();
	
	// 선언 한 번 해줘야함.
	private static BoardDaoImpl instance = new BoardDaoImpl();
	
	// 기본 생성자 
	private BoardDaoImpl() {
		
	}
	
	// 외부에서 사용해야하니 BoardDaoImpl을 반환하는 형태로
	// 외부에서 사용해야하기 때문에 static
	public static BoardDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Board> selectAll() {
		String sql = "SELECT * FROM board";
		List<Board> list= new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 2. 데이터 베이스 연결 해야함
		try {
			// 이렇게 해도 되지만
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "root", "Rlaqhdusdu1@");
			
			// util이 가지고 있는 getConnection 이용
			conn = util.getConnection();
			
			
			// statement를 사용하기 위해서 connection이 가지고 있는 createStatement를 이용하여 만들 수 있따
			stmt = conn.createStatement();
			
			// String을 통해서 sql문을 하나 준비하자. 전체 값을 가져오는 SQL문 작성
			
			// statement가 가지고 있는 executeQuery를 사용하여 sql문을 보내겠다
			rs = stmt.executeQuery(sql);
			
			// 값이 있을 때 가져와
			// DB에서 인덱스는 1부터 시작해요
			while(rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
			
				list.add(board);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 스코프 이슈가 발생하니 상단에 선언
			util.close(rs, stmt, conn);
		}
		
		return list;
	}

	@Override
	public Board selectOne(int id) throws SQLException {
		String sql = "SELECT * FROM board WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Board board = new Board();
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// pstmt에 셋팅하기(1번인덱스에 id 셋팅)
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			// 인덱스로 접근해서 가져오기
				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}
		} finally {
			util.close(rs, pstmt, conn);
		}
		return board;

	}

	// Board를 가지고 왔음
	@Override
	public void insertBoard(Board board) throws SQLException {
		// 굉장히 불편하다.
//		String sql = "INSERT INTO board (title, writer, content) VALUES ('"+board.getTitle()+"','...";
		// 더 진보된 방식의 Statement 사용
		String sql = "INSERT INTO board (title, writer, content) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// util의 getConnection을 이용해서 가지고 올거야
		conn = util.getConnection();
		// pstmt는 connection의 preparedStatement를 이용해서 sql문을 가져올 것
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		
		// 위에 한 결과를 가지고 pstmt가 executeUpdate를 날린다
		pstmt.executeUpdate();
		
		util.close(pstmt, conn);
	}


	@Override
	public void deleteBoard(int id) throws SQLException {
		String sql = "DELETE FROM board WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// pstmt의 1번째 인덱스에 id를 넣을거야
			// 그리고 executeUpdate를 날리겠다
			// executeUpdate의 반환형은 int임
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 데이터가 지워졌습니다.");
		}
		finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateBoard(Board board) throws SQLException {
		String sql = "UPDATE board SET title=?, content=? WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			
			pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void updateViewCnt(int id) throws SQLException {
		String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

}
