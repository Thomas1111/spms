package jxau.spms.common.vo;

import java.util.Date;

/**
 * @author Lai Huiqaing
 * 2014-8-31
 * TODO  开题报告值对象
 */
public class ReportInfoVo {
	
	private String subName;
	private int reportNo;
	private String studentNo;
	private String studentName;
	private Date uploadTime;
	private int exameState;
	private String reportName;
	
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
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	@Override
	public String toString() {
		return "ReportInfoVo [subName=" + subName + ", studentNo=" + studentNo
				+ ", studentName=" + studentName + ", uploadTime=" + uploadTime
				+ ", exameState=" + exameState + ", reportName=" + reportName
				+ "]";
	}
	
}
