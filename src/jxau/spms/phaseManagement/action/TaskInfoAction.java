package jxau.spms.phaseManagement.action;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.tutor.po.TaskInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-15
 * TODO 管理任务书信息
 */
@Controller("taskInfoAction")
@Scope("prototype")

public class TaskInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ReportService reportService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	
	/**
	 * TODO 导师添加任务信息
	 * 下午8:36:34
	 * @return 
	 */
	public String addTaskInfo(){
		String message = "添加成功";
		HashMap<String, Object> params = new HashMap<>(); 	//实例化参数信息
		//设置参数信息
		params.put("subName", request.getParameter("subName"));
		params.put("tutorNo", session.getAttribute("account"));
		params.put("term", request.getParameter("term"));
		//实例化任务信息
		TaskInfo taskInfo = new TaskInfo();
		//设置任务信息内容
		taskInfo.setContent(request.getParameter("content"));
		taskInfo.setDiagram(request.getParameter("digram"));
		taskInfo.setIndicator(request.getParameter("index"));
		taskInfo.setReference(request.getParameter("schedlue"));
		taskInfo.setSchedule(request.getParameter("reference"));
		try {
			reportService.addTaskInfo(taskInfo, params);	//调用service添加方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		System.out.println("************"+message);
		return SUCCESS;
	}
	
}
