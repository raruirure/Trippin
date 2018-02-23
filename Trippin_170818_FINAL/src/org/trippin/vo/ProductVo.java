package org.trippin.vo;

import java.util.Arrays;

public class ProductVo {
	public static final String SAVEFOLDER = "images/upload/product";
	private int no;
	private String seller_id; // �뙋留ㅼ옄�븘�씠�뵒 tr_member_seller
	private String pro_cd; // PK
	private String pro_name; //�긽�뭹紐�
	private String pro_category; //移댄뀒怨좊━
	private int pro_price; // 媛�寃�
	private String pro_img; //�씠誘몄�
	private int pro_display;//�뵒�뒪�뵆�젅�씠 �뿬遺� 1:DISPLAY/ 2:NON-DISPLAY
	private String pro_rdate;
	/* �샃�뀡 �궇吏쒕퀎 珥� �씤�썝�닔 */
	private int pro_cnt_1; // �씤�썝�닔
	private int pro_cnt_2; // �씤�썝�닔
	private int pro_cnt_3; // �씤�썝�닔
	private int pro_cnt_4; // �씤�썝�닔
	private int pro_cnt_5; // �씤�썝�닔
	private int[] pro_cnt;
	
	private String pro_sdate_1; 
	private String pro_sdate_2; 
	private String pro_sdate_3; 
	private String pro_sdate_4; 
	private String pro_sdate_5; 
	private String[] pro_sdate;
	private String[] pro_edate;
	private int pro_hit; // �긽�뭹 議고쉶�닔
	private String pro_detail_cd; // �긽�뭹�꽭遺�肄붾뱶
	private String pro_content; // �긽�꽭�젙蹂�
	private String seller_business_name; // �긽�샇紐� tr_member_seller
	private String seller_agent; // ���몴�옄 tr_member_seller
	private String seller_phonenum; //�뙋留ㅼ옄 �쟾�솕踰덊샇 tr_member_seller
	private int seller_address_post; // �쉶�궗二쇱냼 tr_member_seller
	private String seller_address;
	private String seller_address_detail;
	private String seller_num;
	private int pro_total_date; // �뿬�뻾 湲곌컙
	
	
	public ProductVo(String seller_id, String pro_cd, String pro_detail_cd, String pro_name, String pro_category, int pro_price,
			String pro_img, int pro_display, String pro_content, int pro_hit, String pro_rdate ) {
		this.seller_id = seller_id;
		this.pro_cd = pro_cd;
		this.pro_name = pro_name;
		this.pro_category = pro_category;
		this.pro_price = pro_price;
		this.pro_img = pro_img;
		this.pro_display = pro_display;
		this.pro_rdate = pro_rdate;
		this.pro_hit = pro_hit;
		this.pro_detail_cd = pro_detail_cd;
		this.pro_content = pro_content;
	}
	
	
	
	public ProductVo() {}
	public ProductVo(String pro_cd) {
		this.pro_cd = pro_cd;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_category() {
		return pro_category;
	}
	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_img() {
		return pro_img;
	}
	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}
	public int getPro_display() {
		return pro_display;
	}
	public void setPro_display(int pro_display) {
		this.pro_display = pro_display;
	}
	public String getPro_rdate() {
		return pro_rdate;
	}
	public void setPro_rdate(String pro_rdate) {
		this.pro_rdate = pro_rdate;
	}
	public int getPro_cnt_1() {
		return pro_cnt_1;
	}
	public void setPro_cnt_1(int pro_cnt_1) {
		this.pro_cnt_1 = pro_cnt_1;
	}
	public int getPro_cnt_2() {
		return pro_cnt_2;
	}
	public void setPro_cnt_2(int pro_cnt_2) {
		this.pro_cnt_2 = pro_cnt_2;
	}
	public int getPro_cnt_3() {
		return pro_cnt_3;
	}
	public void setPro_cnt_3(int pro_cnt_3) {
		this.pro_cnt_3 = pro_cnt_3;
	}
	public int getPro_cnt_4() {
		return pro_cnt_4;
	}
	public void setPro_cnt_4(int pro_cnt_4) {
		this.pro_cnt_4 = pro_cnt_4;
	}
	public int getPro_cnt_5() {
		return pro_cnt_5;
	}
	public void setPro_cnt_5(int pro_cnt_5) {
		this.pro_cnt_5 = pro_cnt_5;
	}
	public String getPro_sdate_1() {
		return pro_sdate_1;
	}
	public void setPro_sdate_1(String pro_sdate_1) {
		this.pro_sdate_1 = pro_sdate_1;
	}
	public String getPro_sdate_2() {
		return pro_sdate_2;
	}
	public void setPro_sdate_2(String pro_sdate_2) {
		this.pro_sdate_2 = pro_sdate_2;
	}
	public String getPro_sdate_3() {
		return pro_sdate_3;
	}
	public void setPro_sdate_3(String pro_sdate_3) {
		this.pro_sdate_3 = pro_sdate_3;
	}
	public String getPro_sdate_4() {
		return pro_sdate_4;
	}
	public void setPro_sdate_4(String pro_sdate_4) {
		this.pro_sdate_4 = pro_sdate_4;
	}
	public String getPro_sdate_5() {
		return pro_sdate_5;
	}
	public void setPro_sdate_5(String pro_sdate_5) {
		this.pro_sdate_5 = pro_sdate_5;
	}
	public int[] getPro_cnt() {
		return pro_cnt;
	}
	public void setPro_cnt(int[] pro_cnt) {
		this.pro_cnt = pro_cnt;
	}
	public String[] getPro_sdate() {
		return pro_sdate;
	}
	public void setPro_sdate(String[] pro_sdate) {
		this.pro_sdate = pro_sdate;
	}
	public String[] getPro_edate() {
		return pro_edate;
	}
	public void setPro_edate(String[] pro_edate) {
		this.pro_edate = pro_edate;
	}
	public int getPro_hit() {
		return pro_hit;
	}
	public void setPro_hit(int pro_hit) {
		this.pro_hit = pro_hit;
	}
	public String getPro_detail_cd() {
		return pro_detail_cd;
	}
	public void setPro_detail_cd(String pro_detail_cd) {
		this.pro_detail_cd = pro_detail_cd;
	}
	public String getPro_content() {
		return pro_content;
	}
	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}
	public String getSeller_business_name() {
		return seller_business_name;
	}
	public void setSeller_business_name(String seller_business_name) {
		this.seller_business_name = seller_business_name;
	}
	public String getSeller_agent() {
		return seller_agent;
	}
	public void setSeller_agent(String seller_agent) {
		this.seller_agent = seller_agent;
	}
	public String getSeller_phonenum() {
		return seller_phonenum;
	}
	public void setSeller_phonenum(String seller_phonenum) {
		this.seller_phonenum = seller_phonenum;
	}
	public int getSeller_address_post() {
		return seller_address_post;
	}
	public void setSeller_address_post(int seller_address_post) {
		this.seller_address_post = seller_address_post;
	}
	public String getSeller_address() {
		return seller_address;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
	public String getSeller_address_detail() {
		return seller_address_detail;
	}
	public void setSeller_address_detail(String seller_address_detail) {
		this.seller_address_detail = seller_address_detail;
	}
	public String getSeller_num() {
		return seller_num;
	}
	public void setSeller_num(String seller_num) {
		this.seller_num = seller_num;
	}
	public int getPro_total_date() {
		return pro_total_date;
	}
	public void setPro_total_date(int pro_total_date) {
		this.pro_total_date = pro_total_date;
	}
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", seller_id=" + seller_id + ", pro_cd=" + pro_cd + ", pro_name=" + pro_name
				+ ", pro_category=" + pro_category + ", pro_price=" + pro_price + ", pro_img=" + pro_img
				+ ", pro_display=" + pro_display + ", pro_rdate=" + pro_rdate + ", pro_cnt_1=" + pro_cnt_1
				+ ", pro_cnt_2=" + pro_cnt_2 + ", pro_cnt_3=" + pro_cnt_3 + ", pro_cnt_4=" + pro_cnt_4 + ", pro_cnt_5="
				+ pro_cnt_5 + ", pro_sdate_1=" + pro_sdate_1 + ", pro_sdate_2=" + pro_sdate_2 + ", pro_sdate_3="
				+ pro_sdate_3 + ", pro_sdate_4=" + pro_sdate_4 + ", pro_sdate_5=" + pro_sdate_5 + ", pro_edate="
				+ Arrays.toString(pro_edate) + ", pro_hit=" + pro_hit + ", pro_detail_cd=" + pro_detail_cd
				+ ", pro_content=" + pro_content + ", seller_business_name=" + seller_business_name + ", seller_agent="
				+ seller_agent + ", seller_phonenum=" + seller_phonenum + ", seller_address_post=" + seller_address_post
				+ ", seller_address=" + seller_address + ", seller_address_detail=" + seller_address_detail
				+ ", seller_num=" + seller_num + ", pro_total_date=" + pro_total_date + "]";
	}
	
}
