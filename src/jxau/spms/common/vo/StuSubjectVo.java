package jxau.spms.common.vo;

public class StuSubjectVo {

	private int subjectNo;
	private String subName;
	private String studentNo;
	private String studentName;
	private String subTerm;
	private int applyNum;
	private int leftNum;
	private String tutorName;
	private int stuExaState;
	
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
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
	public String getSubTerm() {
		return subTerm;
	}
	public void setSubTerm(String subTerm) {
		this.subTerm = subTerm;
	}
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	public int getLeftNum() {
		return leftNum;
	}
	public void setLeftNum(int leftNum) {
		this.leftNum = leftNum;
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public int getStuExaState() {
		return stuExaState;
	}
	public void setStuExaState(int stuExaState) {
		this.stuExaState = stuExaState;
	}
	
	@Override
	public String toString() {
		return "StuSubjectVo [subName=" + subName + ", studentNo=" + studentNo
				+ ", studentName=" + studentName + ", subTerm=" + subTerm
				+ ", applyNum=" + applyNum + ", leftNum=" + leftNum
				+ ", tutorName=" + tutorName + ", stuExaState=" + stuExaState
				+ "]";
	}
	
}
