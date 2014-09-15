package jxau.spms.subjectManagement.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.common.vo.VerTutorSubVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.service.StudentService;
import jxau.spms.subjectManagement.service.SubjectService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 2014-9-5
 * TODO 异步加载导师选题信息
 */
@Controller("querySubjectAsyc")
@Scope("prototype")
public class QuerySubjectAsyc extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SubjectService subjectService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private List<SubjectInfo> subjectInfos;
	private List<VerTutorSubVo> tutorSubInfos;
	private Map<String, Object> results;
	private PageVo pageVo = null;
	private String message;

	@Resource(name="subjectService")
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * TODO 获取导师选题信息
	 * @return 
	 */
	public String querySubject(){
		message = "加载成功";
		//获取导师账号
		int role =  (int) request.getSession().getAttribute("role");
		String term =request.getParameter("term");		//获取学期信息
		String type =request.getParameter("type");		//判断是否需要分页
		String utility = request.getParameter("utility");	//获取用途参数
		if ("asyc".equals(type)) {
			pageVo = new PageVo();
			String currentPage = request.getParameter("currentPage");
			pageVo.setCurrentPage(Integer.parseInt(currentPage));
		}
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		//判断是否需要过滤状态
		if (request.getParameter("subState") != null) {
			int subState = Integer.parseInt(request.getParameter("subState"));	//获取审核状态
			params.put("subState", subState);
		}
		//判断角色参数
		if (role == 1) {	//角色为学生
			String studentNo = (String) session.getAttribute("account");	//获取账号信息
			params.put("studentNo", studentNo);		//设置学生学号参数
		}else if (role == 2){
			String tutorNo = (String)session.getAttribute("account");
			params.put("tutorNo", tutorNo);		//设置导师参数
			params.put("stuExaState",1);	//设置学生选题状态为通过	
		}else {			//角色为管理员
			String tutorNo = (String) request.getParameter("tutorNo");	//管理员获取导师工号
			params.put("tutorNo",tutorNo);		//设置导师工号
		}
		params.put("term",term);	//设置学期参数
		try {
			subjectInfos = subjectService.querySubject(params, pageVo,utility);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	/**
	 * TODO	获取学生选题结果
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public String querySubResult(){
		message = "加载成功";
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		pageVo = new PageVo();
		String currentPage = request.getParameter("currentPage");	//获取当前页面
		pageVo.setCurrentPage(Integer.parseInt(currentPage));		//设置当前页面
		String term =request.getParameter("term");		//获取学期信息
		String tutorNo = (String)session.getAttribute("account");
		params.put("tutorNo", tutorNo);	//设置导师账号参数
		params.put("stuExaState",1);	//设置学生选题状态为通过
		params.put("term",term);	//设置学期参数
		
		try {
			results = subjectService.querySubResult(params, pageVo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();	
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	/**
	 * TODO	获取导师选题信息
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public String queryTutSub(){
		message = "加载成功";
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		pageVo = new PageVo();
		String currentPage = request.getParameter("currentPage");	//获取当前页面
		pageVo.setCurrentPage(Integer.parseInt(currentPage));		//设置当前页面
		String term =request.getParameter("term");		//获取学期信息
		String adminNo = (String)session.getAttribute("account");
		
		params.put("adminNo", adminNo);	//设置导师账号参数
		params.put("term",term);	//设置学期参数
		
		try {
			tutorSubInfos = subjectService.queryTutSub(params, pageVo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();	
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	
	public List<VerTutorSubVo> getTutorSubInfos() {
		return tutorSubInfos;
	}

	public void setTutorSubInfos(List<VerTutorSubVo> tutorSubInfos) {
		this.tutorSubInfos = tutorSubInfos;
	}

	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public List<SubjectInfo> getSubjectInfos() {
		return subjectInfos;
	}

	public void setSubjectInfos(List<SubjectInfo> subjectInfos) {
		this.subjectInfos = subjectInfos;
	}

	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
