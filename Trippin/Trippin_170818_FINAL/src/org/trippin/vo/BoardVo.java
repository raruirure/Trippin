package org.trippin.vo;

public class BoardVo {
	private int no;
	private String write_no;
	private String code_key;
	private String user_id;
	private String user_name;
	private String title;
	private String content;
	private String rdate;
	private int hit;
	
	public BoardVo() { }

	public BoardVo(int no, String write_no, String code_key, String user_id, String user_name, String title,
			String content, String rdate, int hit) {
		this.no = no;
		this.write_no = write_no;
		this.code_key = code_key;
		this.user_id = user_id;
		this.user_name = user_name;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
		this.hit = hit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWrite_no() {
		return write_no;
	}

	public void setWrite_no(String write_no) {
		this.write_no = write_no;
	}

	public String getCode_key() {
		return code_key;
	}

	public void setCode_key(String code_key) {
		this.code_key = code_key;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", write_no=" + write_no + ", code_key=" + code_key + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", title=" + title + ", content=" + content + ", rdate=" + rdate
				+ ", hit=" + hit + "]";
	}


}
