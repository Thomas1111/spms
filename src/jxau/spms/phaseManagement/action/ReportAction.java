package jxau.spms.phaseManagement.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.mail.Flags.Flag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.util.GetMethod;

import jxau.spms.common.po.PaperInfo;
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
    private String fileType;
    
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	
	/**
	 * TODO 学生上传开题报告、论文信息
	 * @return 跳转标记位
	 */
	public String uploadFile(){
		String message = "添加成功";
		HashMap<String, Object> params = new HashMap<>();
		ReportInfo reportInfo = null;
		PaperInfo paperInfo = null;
		//获取学生学号
		String studentNo = (String) session.getAttribute("studentNo");
		params.put("studentNo", studentNo);		//设置账号信息
		if (fileType == null || "".equals(fileType)) {
			message = "参数错误";
			return SUCCESS;
		}
		//判断文档类型
		if ("开题报告类".equals(fileType)) {
			params.put("reportTerm", term);		//设置学期信息
			reportInfo = new ReportInfo();
			//设置开题报告信息
			reportInfo.setExameState(2);	//设置开题报告状态为"待审核"
			reportInfo.setReportTerm(term);		//设置学期
			reportInfo.setStudentNo(studentNo);			//设置学生学号
			reportInfo.setUploadTime(new Date());		//设置上传时间
			reportInfo.setReportName(request.getParameter("fileName"));		//设置文件名称
			try {
				FileUpload.upload(term + File.separator +studentNo,upload,
						reportInfo.getReportName(),"report");	//调用上传工具类方法	
				reportService.addReport(reportInfo, params);	//调用service添加方法
			} catch (UnusualParamsException e) {
				// TODO: handle exception
				message = e.getMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			}
		}else {
			params.put("paperTerm", term);		//设置学期信息
			paperInfo = new PaperInfo();
			//设置论文信息
			paperInfo.setExameState(2);
			paperInfo.setMemo("无");
			paperInfo.setPaperName(request.getParameter("fileName"));
			paperInfo.setPaperTerm(term);
			paperInfo.setStudentNo(studentNo);
			paperInfo.setUploadTime(new Date());
			try {
				FileUpload.upload(term + File.separator +studentNo,upload,
						paperInfo.getPaperName(),"paper");	//调用上传工具类方法	
				reportService.addPaper(paperInfo, params);	//调用service添加方法
			} catch (UnusualParamsException e) {
				// TODO: handle exception
				message = e.getMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			}
		}
		request.setAttribute("message", message);	//设置消息属性
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
