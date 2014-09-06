package jxau.spms.common.po;

import java.util.Date;

public class PaperInfo {

	private int paperNo;
	private String studentNo;
	private String tutorNo;
	private Date uploadTime;
	private int exameState;
	private String memo;
	private String paperTerm;
	
	public int getPaperNo() {
		return paperNo;
	}
	public void setPaperNo(int paperNo) {
		this.paperNo = paperNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getTutorNo() {
		return tutorNo;
	}
	public void setTutorNo(String tutorNo) {
		this.tutorNo = tutorNo;
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
	public String getPaperTerm() {
		return paperTerm;
	}
	public void setPaperTerm(String paperTerm) {
		this.paperTerm = paperTerm;
	}
	
}
