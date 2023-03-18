package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ssafy.fit.model.Review;
import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.controller.MainController;

public class MainDaoImpl implements MainDao{
	
	public static List<Video> videoList = new ArrayList<>();
	public static List<Review> reviewList = new ArrayList<>();

	// 싱글턴 패턴
	private static MainDaoImpl instance = new MainDaoImpl();
	
	private MainDaoImpl() {
		
	}
	
	public static MainDaoImpl getInstance() {
		Video video = new Video();
		// 1번째 영상
		video.setTitle("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]");
		video.setFitPartName("전신");
		video.setYoutubeId("gMaB-fG4u4g");
		video.setChannelName("ThankyouBUBU");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 2번째 영상
		video = new Video();
		video.setTitle("하루 15분! 전신 칼로리 불태우는 다이어트 운동");
		video.setFitPartName("전신");
		video.setYoutubeId("swRNeYw1JkY");
		video.setChannelName("ThankyouBUBU");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 3번째 영상
		video = new Video();
		video.setTitle("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]");
		video.setFitPartName("상체");
		video.setYoutubeId("54tTYO-vU2E");
		video.setChannelName("ThankyouBUBU");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 4번째 영상
		video = new Video();
		video.setTitle("상체비만 다이어트 최고의 운동 [상체 핵매운맛]");
		video.setFitPartName("상체");
		video.setYoutubeId("QqqZH3j_vH0");
		video.setChannelName("ThankyouBUBU");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 5번째 영상
		video = new Video();
		video.setTitle("하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]");
		video.setFitPartName("하체");
		video.setYoutubeId("tzN6ypk6Sps");
		video.setChannelName("김강민");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 6번째 영상
		video = new Video();
		video.setTitle("저는 하체 식주의자 입니다");
		video.setFitPartName("하체");
		video.setYoutubeId("u5OgcZdNbMo");
		video.setChannelName("GYM종국");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 7번째 영상
		video = new Video();
		video.setTitle("11자복근 복부 최고의 운동 [복근 핵매운맛]");
		video.setFitPartName("복부");
		video.setYoutubeId("PjGcOP-TQPE");
		video.setChannelName("ThankyouBUBU");
		video.setViewCnt(0);
		videoList.add(video);
		
		// 8번째 영상
		video = new Video();
		video.setTitle("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)");
		video.setFitPartName("복부");
		video.setYoutubeId("7TLk7pscICk");
		video.setChannelName("SomiFit");
		video.setViewCnt(0);
		videoList.add(video);
		
		
		
		return instance;
	}
	
	
	// 비디오 영상 전체 불러오기
	//기본값 : 조회수 순서대로
	public List<Video> selectAll() {
		Collections.sort(videoList);
		
		return videoList;
	}
	
	// 비디오 영상 1개 불러오기
	public Video detail(String id) {
		for(int i = 0 ; i < 8 ; i++) {
			if(videoList.get(i).getYoutubeId().equals(id))
				return videoList.get(i);
		}
		return null;
	}


	// 리뷰 전체 불러오기
	public List<Review> reviewAll() {
		return reviewList;
	}
	
	//영상에 맞는 리뷰 목록 불러오기
	public List<Review> reviewList(String id){
		List<Review> videoReview = new ArrayList<>();
		if(reviewList.size() == 0) return null;
		for(int i = 0 ; i < reviewList.size() ; i++) {
			if(reviewList.get(i).getYoutubeId().equals(id))
				videoReview.add(reviewList.get(i));
		}
		if(videoReview.size() == 0) return null;
		return videoReview;
	}
	
	//리뷰 1개 불러오기
	public Review reviewDetail(String id, int idx) {
		System.out.println(this.reviewList(id).get(0));
		return reviewList(id).get(idx);		
	}
	
	// 리뷰 등록
	public void insertReview(Review review) {	
		int idx = 0;
		if(reviewList(review.getYoutubeId()) != null)
			idx = reviewList(review.getYoutubeId()).size();
		review.setIdx(idx);
		reviewList.add(review);
	}
	
	// 리뷰 삭제
	public void deleteReview(String youtubeId, int idx) {
		if(!reviewList.isEmpty()) {
			for(int i = 0; i < reviewList.size(); i++) {
				if(youtubeId.equals(reviewList.get(i).getYoutubeId()) && idx == reviewList.get(i).getIdx()) {
					reviewList.remove(i);
				}
				if(youtubeId.equals(reviewList.get(i).getYoutubeId()) && idx < reviewList.get(i).getIdx()){
					int newIdx = reviewList.get(i).getIdx() - 1;
					reviewList.get(i).setIdx(newIdx);
				}
			}
		}
	}
	
	// 리뷰 수정
	public void updateReview(String youtubeId, int idx, String content) {
		if(!reviewList.isEmpty()) {
			for(int i = 0; i < reviewList.size(); i++) {
				if(youtubeId.equals(reviewList.get(i).getYoutubeId()) && idx == reviewList.get(i).getIdx()) {
					Review r = reviewList.get(i);
					r.setContent(content);
				}
			}
		}
	}

	// 조회수 수정
	public void updateVideoCnt(String id) {
		for(Video v : videoList) {
			if(v.getYoutubeId().equals(id)){
				v.setViewCnt(v.getViewCnt() + 1);
			}
		}
	}


	

}
