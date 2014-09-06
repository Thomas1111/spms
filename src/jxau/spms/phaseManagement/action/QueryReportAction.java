package jxau.spms.phaseManagement.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.common.vo.ReportInfoVo;
import jxau.spms.exception.ReportNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.ReportService;
import jxau.spms.student.service.StudentService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-1
 * TODO 查询学生开题报告信息
 */
@Controller("queryReportAction")
@Scope("prototype")
public class QueryReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ReportService reportService;
	private HttpServletRequest request;
	
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	
	public String queryReport() {
		String message = "学生开题报告信息";
		HashMap<String, Object> params = new HashMap<>();
		PageVo pageVo = new PageVo();		//实例化分页对象
		request = ServletActionContext.getRequest();
		//获取导师工号
		String tutorNo = request.getParameter("tutorNo");
		//获取开题报告学期
		String reportTerm = request.getParameter("reportTerm");
		//获取当前页面数
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//设置查询参数
		params.put("tutorNo", tutorNo);
		params.put("reportTerm", reportTerm);
		try {
		List<ReportInfoVo>	reportInfo = reportService.queryReport(params);
		int number = reportService.queryRepNumber(params);
		//设置分页对象属性
		pageVo.setCurrentPage(currentPage);
		pageVo.setCount(number);
		//设置request属性(报告对象、分页对象)
		request.setAttribute("reportInfo", reportInfo);
		request.setAttribute("pageVo", pageVo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (ReportNotExistException e) {
			// TODO: handle exception
			message = e.getMessage();
		}finally{
			request.setAttribute("message", message);
		}
		
		return "success";
	}
}
