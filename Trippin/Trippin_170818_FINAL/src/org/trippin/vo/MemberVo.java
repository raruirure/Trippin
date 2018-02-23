package org.trippin.vo;

public class MemberVo {
	private int no;
	private int userLevel=1; //사용자 권한 1:사용자 /2:판매자 /3:관리자 default: 1
	private String userId;
	private String userName;
	private String userPass;
	private String userBirth;
	private String sellerNo; // from TR_MEMBER_SELLER
	private String userProfile;
	private String date;
	private int userOutCheck=1; // 사용자 탈퇴유무 1:IN /2:OUT default:1
	private int sellerState=1; // 판매자 승인 여부from TR_MEMBER_SELLER 1비승인 2 승인
	
	public MemberVo() {}
	public MemberVo(int userLevel, String userId, String userName, String userPass, String userBirth, String sellerNo) {
		this(0, userLevel, userId, userName, userPass, userBirth, sellerNo, "", "", 1, 1);
		// seller state no 로 하기 
	}
	public MemberVo(int no, int userLevel, String userId, String userName, String userPass, String userBirth,
			String sellerNo, String userProfile, String date, int userOutCheck, int sellerState) {
		this.no = no;
		this.userLevel = userLevel;
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userBirth = userBirth;
		this.sellerNo = sellerNo;
		this.userProfile = userProfile;
		this.date = date;
		this.userOutCheck = userOutCheck;
		this.sellerState = sellerState;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}
	
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserOutCheck() {
		return userOutCheck;
	}
	public void setUserOutCheck(int userOutCheck) {
		this.userOutCheck = userOutCheck;
	}
	public int isSellerState() {
		return sellerState;
	}
	public void setSellerState(int sellerState) {
		this.sellerState = sellerState;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", userLevel=" + userLevel + ", userId=" + userId + ", userName=" + userName
				+ ", userPass=" + userPass + ", userBirth=" + userBirth + ", sellerNo=" + sellerNo + ", userProfile="
				+ userProfile + ", date=" + date + ", userOutCheck=" + userOutCheck + ", sellerState=" + sellerState
				+ "]";
	}
}
