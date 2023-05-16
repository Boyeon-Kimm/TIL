package com.ssafy.Test;

import java.sql.SQLException;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
		//등록한다. 
//		Board board = new Board("제가 왕이된 이유는요?", "한장민", "관찰력이 아주 뛰어나기 때문이지요");
//		try {
//			dao.insertBoard(board);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//삭제해보자.
//		try {
//			dao.deleteBoard(10);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			dao.updateViewCnt(4);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(dao.selectOne(3));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//전부 가져와
		for(Board b : dao.selectAll()) {
			System.out.println(b);
		}
	}
}
