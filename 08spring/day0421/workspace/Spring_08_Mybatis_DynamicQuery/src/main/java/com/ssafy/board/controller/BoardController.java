package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/")
	public String showIndex() {
		//보여줄게 없어서 리스트로 바로 점프를뛰자
		return "redirect:list";
	}
	
	
	@GetMapping("list")
	public String list(Model model) {
		List<Board> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("write")
	public String write(Board board) {
		System.out.println("등록전 : "+board);
		boardService.writeBoard(board);
		System.out.println("등록후 : "+board);
//		return "redirect:list"; // 이렇게 하지말고...
		//게시글을 보고 싶다 상세보기로 바로 가고싶어...
		return "redirect:detail?id="+board.getId();
	}
	
	@GetMapping("detail")
	public String detail(Model model, int id) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		
		return "/board/detail";
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	
	@GetMapping("updateform")
	public String updateform(Model model, int id) {
		//지금 게시글 하나 가져오는건 readBoard 밖에 없다. 
		model.addAttribute("board", boardService.readBoard(id));
		return "/board/updateform";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
	
//	검색기능 작성
	@GetMapping("search")
//	public String search(Model model, String key, String word, String or.....) //이거 지저분해 처리할게 많아보여...
	public String search(Model model, SearchCondition condition ) {
		
		
		model.addAttribute("list", boardService.search(condition));
		return "/board/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
