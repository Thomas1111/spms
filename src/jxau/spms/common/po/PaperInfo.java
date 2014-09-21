package jxau.spms.common.po;

import java.util.Date;

public class PaperInfo {

	private int paperNo;
	private String studentNo;
	private Date uploadTime;
	private int exameState;
	private String memo;
	private String paperTerm;
	private String paperName;
	
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
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	@Override
	public String toString() {
		return "PaperInfo [paperNo=" + paperNo + ", studentNo=" + studentNo
				+ ", uploadTime=" + uploadTime + ", exameState=" + exameState
				+ ", memo=" + memo + ", paperTerm=" + paperTerm
				+ ", paperName=" + paperName + "]";
	}
	
}
