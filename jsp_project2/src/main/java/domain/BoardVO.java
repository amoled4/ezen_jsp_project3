package domain;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String regdate;
	private String content;
	private int readcount;
	private String image;
	
	// 생성자
	public BoardVO() {}
	
	// 글작성
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	// 글수정
	public BoardVO(int bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", content="
				+ content + ", readcount=" + readcount + ", image=" + image + "]";
	}




	
	
}
