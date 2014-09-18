package jxau.spms.common.vo;

public class PhaseMissionVo {

	private String tutorNo;
	private int missionNo;
	private String studentNo;
	private String studentName;
	
	public String getTutorNo() {
		return tutorNo;
	}
	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "PhaseMissionVo [tutorNo=" + tutorNo + ", missionNo="
				+ missionNo + ", studentNo=" + studentNo + ", studentName="
				+ studentName + "]";
	}
}
