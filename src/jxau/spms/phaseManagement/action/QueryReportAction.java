package jxau.spms.phaseManagement.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.ReportInfo;
import jxau.spms.common.po.TermInfo;
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
	private HttpSession session;
	private StudentService studentService;
	
	@Resource(name="reportService")
	public void setReportService(ReportService reportService){
		this.reportService = reportService;
	}
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	public String queryReport() {
		String message = "查询成功";
		HashMap<String, Object> params = new HashMap<>();
		PageVo pageVo = new PageVo();		//实例化分页对象
		request = ServletActionContext.getRequest();
		session = request.getSession();
		//获取导师工号
		String tutorNo = (String) session.getAttribute("account");
		List<TermInfo> terms = studentService.queryTerms(null);
		//判断加载信息标志位
		String flag = request.getParameter("flag");
		//获取开题报告学期
		String reportTerm;
		if ("reload".equals(flag)) {
			reportTerm = request.getParameter("reportTerm");	//获取加载学期信息
		}else {
			reportTerm = terms.get(terms.size() - 1).getTerm();		//默认加载最新学期内容
		}
		//获取当前页面数
		String page = request.getParameter("currentPage");
		if (page == null || "".equals(page)) {
			message = "参数错误";
			return "success";
		}
		int currentPage = Integer.parseInt(page.trim());
		//设置分页对象属性
		pageVo.setCurrentPage(currentPage);
		//设置查询参数
		params.put("tutorNo", tutorNo);
		params.put("reportTerm", reportTerm);
		params.put("start",pageVo.getFirstIndex());
		params.put("number",pageVo.getSize());
		//设置term属性
		request.setAttribute("terms", terms);
		request.setAttribute("reportTerm", reportTerm);
		try {
		//查询审核信息
		List<ReportInfoVo>	reportInfo = reportService.queryReport(params);
		int number = reportService.queryRepNumber(params);	//获取审核的数量
		pageVo.setCount(number);	//设置数量
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
