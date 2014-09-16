package jxau.spms.phaseManagement.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.util.GetMethod;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.util.FileUpload;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqaing 
 * 2014-9-16
 * TODO 处理选题管理信息
 */
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ReportService reportService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	// 封装上传文件域的属性  
    private File upload;  
    private String term;	//当前学期
    
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	
	/**
	 * TODO 添加开题报告
	 * @return 跳转标记位
	 */
	public String addReport(){
		String message = "添加成功";
		HashMap<String, Object> params = new HashMap<>();
		ReportInfo reportInfo = new ReportInfo();
		//获取学生学号
		String studentNo = (String) session.getAttribute("account");
		params.put("studentNo", studentNo);		//设置账号信息
		params.put("reportTerm", term);		//设置学期信息
		//设置开题报告信息
		reportInfo.setExameState(2);	//设置开题报告状态为"待审核"
		reportInfo.setReportTerm(term);		//设置学期
		reportInfo.setStudentNo(studentNo);			//设置学生学号
		reportInfo.setUploadTime(new Date());		//设置上传时间
		reportInfo.setReportName(request.getParameter("fileName"));		//设置文件名称
		//设置上传文件标志名
		try {
			FileUpload.upload(reportInfo.getReportTerm(),upload,
					reportInfo.getReportName(),"report");	//调用上传工具类方法	
			reportService.addReport(reportInfo, params);	//调用service添加方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		return SUCCESS;
	}
	
	
	 public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
}
