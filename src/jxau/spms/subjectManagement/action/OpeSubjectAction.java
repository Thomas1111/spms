package jxau.spms.subjectManagement.action;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxau.spms.exception.SubNumberOutOfRange;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-10
 * TODO 学生申请、退选选题
 */
@Controller("opeSubjectAction")
@Scope("prototype")
public class OpeSubjectAction extends ActionSupport {

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
	public String opeSubject(){
		String message = null;
		request = ServletActionContext.getRequest();
		session = request.getSession();
		HashMap<String, Object> params = new HashMap<>();
		//设置参数信息
		params.put("subjectNo", request.getParameter("subjectNo"));		
		params.put("opeType", request.getParameter("opeType"));
		params.put("studentNo", session.getAttribute("account"));
		params.put("opeType", request.getParameter("leftNum"));
		try {
			message = subjectService.verifySubject(params);	//调用service审核方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (SubNumberOutOfRange e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		//设置reque审核信息属性
		request.setAttribute("message", message);

		return SUCCESS;
	}
}
