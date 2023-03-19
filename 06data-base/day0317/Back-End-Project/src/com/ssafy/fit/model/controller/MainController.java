package com.ssafy.fit.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.fit.model.Review;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.MainDaoImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MainDaoImpl dao = MainDaoImpl.getInstance();
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//encoding 맞춰주기
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		//리퀘스트 받아서 실행을 위한 메소드로 넘겨주기
		String act = request.getParameter("act");
		
		switch(act) {
		case "index":
			System.out.println("index");
			doIndex(request, response);
			break;
		case "videodetail":
			doVideoDetail(request, response);
			break;
		case "writeform":
			System.out.println("here!");
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "delete":
			doReviewDelete(request, response);
			break;
		case "updateform":
			doUpdateForm(request, response);
			break;
		case "update":
			doReviewUpdate(request, response);
			break;
		case "loginpage":
			doLoginPage(request, response);
			break;
		case "registpage":
			doRegistPage(request, response);
			break;
		}
		
	}



	private void doRegistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/ssafit/regist.jsp").forward(request, response);
		
	}



	private void doLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/ssafit/login.jsp").forward(request, response);	
	}



	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		request.setAttribute("video", dao.detail(id));
		
		int idx = Integer.parseInt(request.getParameter("reviewIdx"));	
		System.out.println(idx);
		request.setAttribute("review", dao.reviewDetail(id, idx));
		
		request.getRequestDispatcher("/ssafit/updateform.jsp").forward(request, response);	
	}

	private void doReviewUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("업뎃");
		String id = request.getParameter("videoId");
		int idx = Integer.parseInt(request.getParameter("reviewIdx"));
		String content = request.getParameter("content");
		dao.updateReview(id, idx, content);		

		response.sendRedirect("main?act=videodetail&videoId="+id);
	}

	private void doReviewDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		int idx = Integer.parseInt(request.getParameter("reviewIdx"));
		dao.deleteReview(id, idx);		

		response.sendRedirect("main?act=videodetail&videoId="+id);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		System.out.println("write");
		Review r = new Review();
		
		r.setYoutubeId(request.getParameter("videoId"));
		r.setWriter(request.getParameter("writer"));
		r.setContent(request.getParameter("content"));
		

		dao.insertReview(r);
		List<Review> rl = dao.reviewAll();
		for(int i = 0 ; i < rl.size() ; i++) {
			System.out.println(rl.get(i));
		}
//		reponse.sne
		response.sendRedirect("main?act=videodetail&videoId="+id);
//		request.getRequestDispatcher("main?act=videodetail&videoId"+id).forward(request, response);		
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		dao.updateVideoCnt(id);
		request.setAttribute("video", dao.detail(id));
		System.out.println(id);
		request.getRequestDispatcher("/ssafit/writeform.jsp").forward(request, response);		
	}

	private void doVideoDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		dao.updateVideoCnt(id);
		request.setAttribute("video", dao.detail(id));
		List<Review> rlist = dao.reviewList(id);
		request.setAttribute("reviewlist", rlist);
		request.getRequestDispatcher("/ssafit/videoDetail.jsp").forward(request, response);
	}

	private void doIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaa");
		List<Video> list = dao.selectAll();
		request.setAttribute("videolist", list);
		request.getRequestDispatcher("/ssafit/index.jsp").forward(request, response);
	}

}
