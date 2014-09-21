package jxau.spms.phaseManagement.action;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.vo.TaskInfoVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-5
 * TODO 异步加载任务书信息信息
 */
@Controller("queryTaskAsyc")
@Scope("prototype")
public class QueryTaskAsyc extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ReportService reportService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	private String message;
	private TaskInfoVo taskInfoVo;
	
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	/**
	 * TODO
	 * @return
	 */
	public String queryTask(){
		message = "查询成功";
		HashMap<String, Object> params = new HashMap<>();
		//获取参数信息
		String term = request.getParameter("term");
		String studentNo = (String) session.getAttribute("studentNo");
		//设置参数信息
		params.put("term", term);
		params.put("studentNo", studentNo);
		
		System.out.print("term" + term);
		System.out.print("studentNo" + studentNo);
		try {
			//调用service查询方法
			taskInfoVo = reportService.queryTaskInfo(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		//System.out.println("************" + message);
		
		return SUCCESS;
	}
	
	/**
	 * TODO 审核开题报告
	 * @return
	 */
	public String verifyReport(){
		message = "审核成功";
		HashMap<String, Object> params = new HashMap<>();
		//设置参数信息
		params.put("type", request.getParameter("type"));
		params.put("reportNo",request.getParameter("reportNo"));
		try {
			reportService.verifyReport(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TaskInfoVo getTaskInfoVo() {
		return taskInfoVo;
	}
	public void setTaskInfoVo(TaskInfoVo taskInfoVo) {
		this.taskInfoVo = taskInfoVo;
	}
	
}
