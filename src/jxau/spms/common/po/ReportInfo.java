package jxau.spms.common.po;

import java.util.Date;

public class ReportInfo {

	private int reportNo;
	private String studentNo;
	private String tutorNo;
	private Date uploadTime;
	private int exameState;
	private String memo;
	private String reportTerm;
	private String reportName;
	
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
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
	public String getReportTerm() {
		return reportTerm;
	}
	public void setReportTerm(String reportTerm) {
		this.reportTerm = reportTerm;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	@Override
	public String toString() {
		return "ReportInfo [reportNo=" + reportNo + ", studentNo=" + studentNo
				+ ", tutorNo=" + tutorNo + ", uploadTime=" + uploadTime
				+ ", exameState=" + exameState + ", memo=" + memo
				+ ", reportTerm=" + reportTerm + ", reportName=" + reportName
				+ "]";
	}
	
}
