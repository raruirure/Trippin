package org.trippin.vo;

public class CartVo {
	private int no;
	private String pro_cd;
	private String pro_category;
	/*옵션*/
	private String pro_detail_cd;
	private String pro_sdate;
	private String pro_edate;
	private String user_id;
	private String pro_name;
	private int pro_price;
	private int cart_ea;
	
	
	public CartVo() { }


	public CartVo(int no, String pro_cd, String pro_category, String pro_detail_cd, String pro_sdate, String pro_edate,
			String user_id, String pro_name, int pro_price, int cart_ea) {
		super();
		this.no = no;
		this.pro_cd = pro_cd;
		this.pro_category = pro_category;
		this.pro_detail_cd = pro_detail_cd;
		this.pro_sdate = pro_sdate;
		this.pro_edate = pro_edate;
		this.user_id = user_id;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.cart_ea = cart_ea;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getPro_cd() {
		return pro_cd;
	}


	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}


	public String getPro_category() {
		return pro_category;
	}


	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
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


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
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


	public int getCart_ea() {
		return cart_ea;
	}


	public void setCart_ea(int cart_ea) {
		this.cart_ea = cart_ea;
	}


	@Override
	public String toString() {
		return "CartVo [no=" + no + ", pro_cd=" + pro_cd + ", pro_category=" + pro_category + ", pro_detail_cd="
				+ pro_detail_cd + ", pro_sdate=" + pro_sdate + ", pro_edate=" + pro_edate + ", user_id=" + user_id
				+ ", pro_name=" + pro_name + ", pro_price=" + pro_price + ", cart_ea=" + cart_ea + "]";
	}



}
