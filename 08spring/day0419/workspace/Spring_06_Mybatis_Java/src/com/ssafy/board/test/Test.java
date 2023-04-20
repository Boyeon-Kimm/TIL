package com.ssafy.board.test;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
		
//		Board board = new Board("이거 되나요요요요 ??", "이종민", "select * ....");
//		
//		dao.insertBoard(board);
		
//		dao.deleteBoard(1);
		
		Board bb = dao.selectOne(3);
		bb.setTitle("대답잘하는법 공유해드림");
		bb.setContent("채팅 뿐만아니라 열정도 있어야함.");
		
		dao.updateBoard(bb);
		
		
		
		System.out.println(dao.selectAll().size());
		for (Board b : dao.selectAll()) {
			System.out.println(b);
		}
		
//		System.out.println(dao.selectOne(1));
		
	}
}
