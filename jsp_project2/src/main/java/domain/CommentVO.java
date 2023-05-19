package domain;

public class CommentVO {
/*
 * create table comment(
cno int not null auto_increment,
bno int default 0,
writer varchar(100) default “unknown”,
content varchar(1000) not null,
regdate datetime default now(),
primary key(cno));
 */
	
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String regdate;
	
	// 생성자
	public CommentVO() {}
	
	// post(bno, writer, content)
	public CommentVO(int bno, String writer, String content) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.content = content;
	}
	
	// writer, content, cno
	public CommentVO(String writer, String content, int cno) {
		super();
		this.cno = cno;
		this.writer = writer;
		this.content = content;
	}
	
	// modify(cno, content)
	public CommentVO(int cno, String content) {
		super();
		this.cno = cno;
		this.content = content;
	}
	
	// list(전부)
	public CommentVO(int cno, int bno, String writer, String content, String regdate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
	
}
