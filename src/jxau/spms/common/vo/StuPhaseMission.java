package jxau.spms.common.vo;

import java.util.Date;

public class StuPhaseMission {

	private String studentName;
	private String studentNo;
	private int missionNo;
	private String tutorNo;
	private String misName;
	private Date startTime;
	private Date uploadTime;
	private Date endTime;
	private String misBrief;
	private String phaseTerm;
	private String sendObject;
	private int exameState;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public int getMissionNo() {
		return missionNo;
	}
	public void setMissionNo(int missionNo) {
		this.missionNo = missionNo;
	}
	public String getTutorNo() {
		return tutorNo;
	}
	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}
	public String getMisName() {
		return misName;
	}
	public void setMisName(String misName) {
		this.misName = misName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getMisBrief() {
		return misBrief;
	}
	public void setMisBrief(String misBrief) {
		this.misBrief = misBrief;
	}
	public String getPhaseTerm() {
		return phaseTerm;
	}
	public void setPhaseTerm(String phaseTerm) {
		this.phaseTerm = phaseTerm;
	}
	public String getSendObject() {
		return sendObject;
	}
	public void setSendObject(String sendObject) {
		this.sendObject = sendObject;
	}
	public int getExameState() {
		return exameState;
	}
	public void setExameState(int exameState) {
		this.exameState = exameState;
	}
	@Override
	public String toString() {
		return "StuPhaseMission [studentName=" + studentName + ", studentNo="
				+ studentNo + ", missionNo=" + missionNo + ", tutorNo="
				+ tutorNo + ", misName=" + misName + ", startTime=" + startTime
				+ ", uploadTime=" + uploadTime + ", endTime=" + endTime
				+ ", misBrief=" + misBrief + ", phaseTerm=" + phaseTerm
				+ ", sendObject=" + sendObject + ", exameState=" + exameState
				+ "]";
	}

}
