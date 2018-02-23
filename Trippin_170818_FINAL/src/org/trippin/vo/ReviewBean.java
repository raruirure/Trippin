package org.trippin.vo;

public class ReviewBean {
	private String code_class;
	private int write_no;
	private String code;
	private String user_id;
	private String main_title;
	private String sdate;
	private String edate;
	private String banner_img;
	private String review_content;
	private String category;
	private int review_DayCnt;
	private int hit;
	
	public ReviewBean() {}

	public ReviewBean(String code_class, int write_no, String code, String user_id, String main_title, String sdate,
			String edate, String banner_img, String review_content,String category,int review_DayCnt,int hit) {
		this.code_class = code_class;
		this.write_no = write_no;
		this.code = code;
		this.user_id = user_id;
		this.main_title = main_title;
		this.sdate = sdate;
		this.edate = edate;
		this.banner_img = banner_img;
		this.review_content = review_content;
		this.category = category;
		this.review_DayCnt = review_DayCnt;
		this.hit = hit;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode_class() {
		return code_class;
	}

	public void setCode_class(String code_class) {
		this.code_class = code_class;
	}

	public int getWrite_no() {
		return write_no;
	}

	public void setWrite_no(int write_no) {
		this.write_no = write_no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMain_title() {
		return main_title;
	}

	public void setMain_title(String main_title) {
		this.main_title = main_title;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getBanner_img() {
		return banner_img;
	}

	public void setBanner_img(String banner_img) {
		this.banner_img = banner_img;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public int getReview_DayCnt() {
		return review_DayCnt;
	}

	public void setReview_DayCnt(int review_DayCnt) {
		this.review_DayCnt = review_DayCnt;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "ReviewBean [code_class=" + code_class + ", write_no=" + write_no + ", code=" + code + ", user_id="
				+ user_id + ", main_title=" + main_title + ", sdate=" + sdate + ", edate=" + edate + ", banner_img="
				+ banner_img + ", review_content=" + review_content + ", category=" + category + ", review_DayCnt="
				+ review_DayCnt + ", hit=" + hit + "]";
	}
	
}
