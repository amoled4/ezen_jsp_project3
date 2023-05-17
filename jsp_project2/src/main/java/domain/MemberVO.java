package domain;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String regdate;
	private String last_login;
	private int auth;
	
	// 생성자
	public MemberVO() {}
	
	// 로그인
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 회원가입
	public MemberVO(String id, String pw, String name, String phone, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", regdate=" + regdate + ", last_login=" + last_login + ", auth=" + auth + "]";
	}
	
	
	
}
