package org.trippin.vo;

public class PlanBean {
	private String code_class;
	private int write_no;
	private String code;
	private String user_id;
	private String main_title;
	private String sdate;
	private String edate;
	private String banner_img;
	private String plan_content;
	private String category;
	private int plan_DayCnt;
	private int hit;
	

	

	public PlanBean() {}
	public PlanBean(String code_class, int write_no, String code, String user_id, String main_title, String sdate,
			String edate, String banner_img, String plan_content,String category,int plan_DayCnt) {
		this.code_class = code_class;
		this.write_no = write_no;
		this.code = code;
		this.user_id = user_id;
		this.main_title = main_title;
		this.sdate = sdate;
		this.edate = edate;
		this.banner_img = banner_img;
		this.plan_content = plan_content;
		this.category = category;
		this.plan_DayCnt = plan_DayCnt;
	}
	public PlanBean(String code_class, int write_no, String code, String user_id, String main_title, String sdate,
			String edate, String banner_img, String plan_content,String category,int plan_DayCnt,int hit) {
		this.code_class = code_class;
		this.write_no = write_no;
		this.code = code;
		this.user_id = user_id;
		this.main_title = main_title;
		this.sdate = sdate;
		this.edate = edate;
		this.banner_img = banner_img;
		this.plan_content = plan_content;
		this.category = category;
		this.plan_DayCnt = plan_DayCnt;
		this.hit = hit;
	}

	
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getPlan_DayCnt() {
		return plan_DayCnt;
	}



	public void setPlan_DayCnt(int plan_DayCnt) {
		this.plan_DayCnt = plan_DayCnt;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}


	public String getPlan_content() {
		return plan_content;
	}



	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
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



	@Override
	public String toString() {
		return "PlanBean [code_class=" + code_class + ", write_no=" + write_no + ", code=" + code + ", user_id="
				+ user_id + ", main_title=" + main_title + ", sdate=" + sdate + ", edate=" + edate + ", banner_img="
				+ banner_img + ", plan_content=" + plan_content + ", category=" + category + ", plan_DayCnt="
				+ plan_DayCnt + "]";
	}

	
}
