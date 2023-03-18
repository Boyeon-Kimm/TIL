package com.ssafy.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

// 1. JDBC 드라이버를 로드
// 2. 데이터 베이스 연결(Connection)
// 3. SQL 준비 및 실행
// 4. 데이터 베이스 연결 해제

public class JDBCtest {
	
	public JDBCtest() {
		// 드라이버를 로드한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JDBCtest db = new JDBCtest();
		
		// Board라는 b는 db가 가지고 있는 selectAll 이라는 메소드를 가지고 있고
		for(Board b : db.selectAll()) {
			System.out.println(b);
		}
	}
	
	private List<Board> selectAll(){
		List<Board> list= new ArrayList<>();
		
		// 2. 데이터 베이스 연결 해야함
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "root", "Rlaqhdusdu1@");
			
			// statement를 사용하기 위해서 connection이 가지고 있는 createStatement를 이용하여 만들 수 있따
			Statement stmt = conn.createStatement();
			
			// String을 통해서 sql문을 하나 준비하자. 전체 값을 가져오는 SQL문 작성
			String sql = "SELECT * FROM board";
			
			// statement가 가지고 있는 executeQuery를 사용하여 sql문을 보내겠다
			ResultSet rs = stmt.executeQuery(sql);
			
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
		}
		
		return list;
	}
	
}
