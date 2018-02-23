package org.trippin.vo;

public class OrderVo {
	private int no;
	private String user_id;
	private String pro_cd;
	private String pro_sell_date;
	private int pro_cnt;
	private String pro_cancel;
	private String pro_detail_cd;
	private String pro_sdate;
	private String pro_edate;
	private String pro_name;
	private int pro_price;
	
	public OrderVo() { }

	public OrderVo(int no, String user_id, String pro_cd, String pro_sell_date, int pro_cnt, String pro_cancel,
			String pro_detail_cd, String pro_sdate, String pro_edate, String pro_name, int pro_price) {
		super();
		this.no = no;
		this.user_id = user_id;
		this.pro_cd = pro_cd;
		this.pro_sell_date = pro_sell_date;
		this.pro_cnt = pro_cnt;
		this.pro_cancel = pro_cancel;
		this.pro_detail_cd = pro_detail_cd;
		this.pro_sdate = pro_sdate;
		this.pro_edate = pro_edate;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPro_cd() {
		return pro_cd;
	}

	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getPro_sell_date() {
		return pro_sell_date;
	}

	public void setPro_sell_date(String pro_sell_date) {
		this.pro_sell_date = pro_sell_date;
	}

	public int getPro_cnt() {
		return pro_cnt;
	}

	public void setPro_cnt(int pro_cnt) {
		this.pro_cnt = pro_cnt;
	}

	public String getPro_cancel() {
		return pro_cancel;
	}

	public void setPro_cancel(String pro_cancel) {
		this.pro_cancel = pro_cancel;
	}

	public String getPro_detail_cd() {
		return pro_detail_cd;
	}

	public void setPro_detail_cd(String pro_detail_cd) {
		this.pro_detail_cd = pro_detail_cd;
	}

	public String getPro_sdate() {
		return pro_sdate;
	}

	public void setPro_sdate(String pro_sdate) {
		this.pro_sdate = pro_sdate;
	}

	public String getPro_edate() {
		return pro_edate;
	}

	public void setPro_edate(String pro_edate) {
		this.pro_edate = pro_edate;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", user_id=" + user_id + ", pro_cd=" + pro_cd + ", pro_sell_date=" + pro_sell_date
				+ ", pro_cnt=" + pro_cnt + ", pro_cancel=" + pro_cancel + ", pro_detail_cd=" + pro_detail_cd
				+ ", pro_sdate=" + pro_sdate + ", pro_edate=" + pro_edate + ", pro_name=" + pro_name + ", pro_price="
				+ pro_price + "]";
	}

	
}
