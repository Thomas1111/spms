package jxau.spms.admin.po;

public class AdminBasicInfo {

	private String adminNo;
	private String adminName;
	private int sex;
	private String nation;
	private String college;
	private String rank;
	private String adminTitle;
	private String eduBackground;
	private String telephone;
	private String email;
	private String remarks;
	
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getAdminTitle() {
		return adminTitle;
	}
	public void setAdminTitle(String adminTitle) {
		this.adminTitle = adminTitle;
	}
	public String getEduBackground() {
		return eduBackground;
	}
	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "AdminBasicInfo [adminNo=" + adminNo + ", adminName="
				+ adminName + ", sex=" + sex + ", nation=" + nation
				+ ", college=" + college + ", rank=" + rank + ", adminTitle="
				+ adminTitle + ", eduBackground=" + eduBackground
				+ ", telephone=" + telephone + ", email=" + email
				+ ", remarks=" + remarks + "]";
	}
	
}
