package com.ssafy.fit.model;

public class Review {
	private String youtubeId;
	private int idx;
	private String writer;
	private String content;
	
	public Review() {
		
	}
	
	public Review(String youtubeId, int idx, String writer, String content) {
		super();
		this.youtubeId = youtubeId;
		this.idx = idx;
		this.writer = writer;
		this.content = content;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [youtubeId=" + youtubeId + ", idx=" + idx + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
}
