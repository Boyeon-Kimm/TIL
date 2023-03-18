package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ssafy.fit.model.Review;
import com.ssafy.fit.model.Video;

public interface MainDao {
	
	// 전체 영상
	public List<Video> selectAll();
	
	//영상 정보 불러오기
	public Video detail(String id);
	
	// 리뷰 전체 불러오기
	public List<Review> reviewAll();
	
	//영상에 맞는 리뷰 목록 불러오기
	public List<Review> reviewList(String id);
	
	//리뷰 1개 불러오기
	public Review reviewDetail(String id, int idx) ;
	
	// 조회수 증가
	public void updateVideoCnt(String id);
	
	// 리뷰 등록
	public void insertReview(Review review);
	
	// 리뷰 삭제
	public void deleteReview(String youtubeId, int idx);
	
	// 리뷰 수정
	public void updateReview(String youtubeId, int idx, String content);


	
}
