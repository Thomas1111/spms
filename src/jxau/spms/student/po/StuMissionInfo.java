package jxau.spms.student.po;

import java.util.Date;

public class StuMissionInfo {

	private int missionNo;
	private String studentNo;
	private Date uploadTime;
	private int exameState;
	private String memo;
	private String missionName;
	
	public int getMissionNo() {
		return missionNo;
	}
	public void setMissionNo(int missionNo) {
		this.missionNo = missionNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
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
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	
	@Override
	public String toString() {
		return "StuMissionInfo [missionNo=" + missionNo + ", studentNo="
				+ studentNo + ", uploadTime=" + uploadTime + ", exameState="
				+ exameState + ", memo=" + memo + ", missionName="
				+ missionName + "]";
	}
	
}
