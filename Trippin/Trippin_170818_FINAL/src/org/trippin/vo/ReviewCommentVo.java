package org.trippin.vo;

public class ReviewCommentVo {
	private int no;
	private String code_class;
	private String codeCmt;
	private String userId;
	private String code;
	private String reCmtContent;
	private String reCmtRgdt;
	
	public ReviewCommentVo(){}
	
	// Write 용
	public ReviewCommentVo(String code_class, String codeCmt, String userId, String code, String reCmtContent,
			String reCmtRgdt) {
		this.code_class = code_class;
		this.codeCmt = codeCmt;
		this.userId = userId;
		this.code = code;
		this.reCmtContent = reCmtContent;
		this.reCmtRgdt = reCmtRgdt;
	}
	
	// Read 용
	public ReviewCommentVo(String userId, String codeCmt, String reCmtContent,String reCmtRgdt) {
		this.userId = userId;
		this.codeCmt = codeCmt;
		this.reCmtContent = reCmtContent;
		this.reCmtRgdt = reCmtRgdt;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getcode_class() {
		return code_class;
	}
	public void setcode_class(String code_class) {
		this.code_class = code_class;
	}
	public String getCodeCmt() {
		return codeCmt;
	}
	public void setCodeCmt(String codeCmt) {
		this.codeCmt = codeCmt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getcode() {
		return code;
	}
	public void setcode(String code) {
		this.code = code;
	}
	public String getReCmtContent() {
		return reCmtContent;
	}
	public void setReCmtContent(String reCmtContent) {
		this.reCmtContent = reCmtContent;
	}
	public String getReCmtRgdt() {
		return reCmtRgdt;
	}
	public void setReCmtRgdt(String reCmtRgdt) {
		this.reCmtRgdt = reCmtRgdt;
	}
	@Override
	public String toString() {
		return "ProductReviewCommentVo [no=" + no + ", code_class=" + code_class + ", codeCmt=" + codeCmt + ", userId=" + userId
				+ ", code=" + code + ", reCmtContent=" + reCmtContent + ", reCmtRgdt=" + reCmtRgdt + "]";
	}
}