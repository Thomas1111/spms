package jxau.spms.subjectManagement.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
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
	private HttpServletRequest request;
	private List<SubjectInfo> subjectInfos;
	private PageVo pageVo;
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
		pageVo = null;
		message = "加载成功";
		request = ServletActionContext.getRequest();
		//获取导师账号
		String tutorNo = (String) request.getSession().getAttribute("account");
		String term =request.getParameter("term");		//获取学期信息
		String type =request.getParameter("type");		//判断是否需要分页
		if ("asyc".equals(type)) {
			pageVo = new PageVo();
		}
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		params.put("tutorNo", tutorNo);
		params.put("term",term);
		try {
			subjectInfos = subjectService.querySubject(params, pageVo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
		
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
