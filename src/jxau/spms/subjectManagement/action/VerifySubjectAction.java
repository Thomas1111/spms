package jxau.spms.subjectManagement.action;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.handlers.message_rfc822;

/**
 * @author Lai Huiqiang
 * 2014-9-10
 * TODO 审核选题信息
 */
@Controller("verifySubjectAction")
@Scope("prototype")
public class VerifySubjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SubjectService subjectService;
	private HttpServletRequest request;
	private HttpSession session;

	@Resource(name="subjectService")
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * TODO 审核选题信息
	 * @return 
	 */
	public String verifySubject(){
		String message = null;
		request = ServletActionContext.getRequest();
		session = request.getSession();
		HashMap<String, Object> params = new HashMap<>();
		int role = (int) session.getAttribute("role");	//获取角色编号
		String term = request.getParameter("term");
		params.put("term", term);		//设置学期参数
		//判断角色用户
		if (role == 2) {	//判断是否是导师角色
			//设置导师审核学生选题信息
			params.put("studentNo", request.getParameter("studentNo"));
			params.put("stuExaState",request.getParameter("stuExaState"));
		}else {
			//设置管理审核导师选题信息
			params.put("tutorNo", request.getParameter("tutorNo"));
			params.put("exameState", request.getParameter("exameState"));
		}
		try {
			message = subjectService.verifySubject(params);	//调用service审核方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		//设置reque审核信息属性
		request.setAttribute("message", message);

		return SUCCESS;
	}
}
