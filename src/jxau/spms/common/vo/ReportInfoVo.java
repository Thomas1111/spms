package jxau.spms.common.vo;

import java.util.Date;

/**
 * @author Lai Huiqaing
 * 2014-8-31
 * TODO  开题报告值对象
 */
public class ReportInfoVo {

	private String subName;
	private String studentNo;
	private String studentName;
	private Date uploadTime;
	private int exameState;
	private String identifier;
	
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
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@Override
	public String toString() {
		return "ReportInfoVo [subName=" + subName + ", studentNo=" + studentNo
				+ ", studentName=" + studentName + ", uploadTime=" + uploadTime
				+ ", exameState=" + exameState + ", identifier=" + identifier
				+ "]";
	}
	
}
