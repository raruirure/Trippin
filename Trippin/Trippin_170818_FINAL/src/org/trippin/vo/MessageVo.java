package org.trippin.vo;

public class MessageVo {
	private int no;
	private String title;
	private String send_user_id;
	private String res_user_id;
	private String message_content;
	private String send_date;
	private String write_class;
	private String write_address;
	
	public MessageVo(){}
	// 일반 메시지
	public MessageVo(String title, String send_user_id, String res_user_id, String message_content, String send_date) {
		this.title = title;
		this.send_user_id = send_user_id;
		this.res_user_id = res_user_id;
		this.message_content = message_content;
		this.send_date = send_date;
	}
	
	// 신고용 메시지
	public MessageVo(String title, String send_user_id, String res_user_id, String message_content, String write_class,
			String write_address, String send_date) {
		this.title = title;
		this.send_user_id = send_user_id;
		this.res_user_id = res_user_id;
		this.message_content = message_content;
		this.write_class = write_class;
		this.write_address = write_address;
		this.send_date = send_date;
	}
	
	// 메시지 리스트
	public MessageVo(int no, String send_user_id, String title, String send_date) {
		this.no = no;
		this.send_user_id = send_user_id;
		this.title = title;
		this.send_date = send_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getSend_user_id() {
		return send_user_id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setSend_user_id(String send_user_id) {
		this.send_user_id = send_user_id;
	}

	public String getRes_user_id() {
		return res_user_id;
	}

	public void setRes_user_id(String res_user_id) {
		this.res_user_id = res_user_id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public String getWrite_class() {
		return write_class;
	}

	public void setWrite_class(String write_class) {
		this.write_class = write_class;
	}
	
	public String getSend_date() {
		return send_date;
	}
	
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	public String getWrite_address() {
		return write_address;
	}
	public void setWrite_address(String write_address) {
		this.write_address = write_address;
	}
	@Override
	public String toString() {
		return "MessageVo [no=" + no + ", title=" + title + ", send_user_id=" + send_user_id + ", res_user_id="
				+ res_user_id + ", message_content=" + message_content + ", send_date=" + send_date + ", write_class="
				+ write_class + ", write_address=" + write_address + "]";
	}
}