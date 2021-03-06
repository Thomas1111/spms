package jxau.spms.tutor.po;

import java.util.Date;

public class PhaseMissionInfo {

	private int missionNo;
	private String tutorNo;
	private String misName;
	private Date startTime;
	private Date endTime;
	private String misBrief;
	private String phaseTerm;
	private String sendObject;
	
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
	@Override
	public String toString() {
		return "PhaseMissionInfo [missionNo=" + missionNo + ", tutorNo="
				+ tutorNo + ", misName=" + misName + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", misBrief=" + misBrief
				+ ", phaseTerm=" + phaseTerm + ", sendObject=" + sendObject
				+ "]";
	}
	
}
