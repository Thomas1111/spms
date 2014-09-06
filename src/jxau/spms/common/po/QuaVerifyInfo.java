package jxau.spms.common.po;

import java.util.Date;

public class QuaVerifyInfo {

	private int quaNo;
	private String adminNo;
	private Date time;
	private int exameState;
	private String memo;
	
	public int getQuaNo() {
		return quaNo;
	}
	public void setQuaNo(int quaNo) {
		this.quaNo = quaNo;
	}
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getExameState() {
		return exameState;
	}
	public void setExameState(int exameState) {
		this.exameState = exameState;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
