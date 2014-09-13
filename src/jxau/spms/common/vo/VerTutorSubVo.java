package jxau.spms.common.vo;

public class VerTutorSubVo {

	private String tutorNo;
	private String tutorName;
	private int sex;
	private String college;
	private String major;
	private int subjectNum;
	private int exameState;
	
	public String getTutorNo() {
		return tutorNo;
	}
	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(int subjectNum) {
		this.subjectNum = subjectNum;
	}
	public int getExameState() {
		return exameState;
	}
	public void setExameState(int exameState) {
		this.exameState = exameState;
	}
	
	@Override
	public String toString() {
		return "VerTutorSubVo [tutorNo=" + tutorNo + ", tutorName=" + tutorName
				+ ", sex=" + sex + ", college=" + college + ", major=" + major
				+ ", subjectNum=" + subjectNum + "]";
	}

}
