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
 * TODO 学生申请、退选选题以及导师、管理员审核选题信息
 */
@Controller("opeSubjectAction")
@Scope("prototype")
public class OpeSubjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SubjectService subjectService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private String message;

	@Resource(name="subjectService")
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	/**
	 * TODO 审核选题信息
	 * @return 
	 */
	public String opeSubject(){
		HashMap<String, Object> params = new HashMap<>();
		String leftNum = request.getParameter("leftNum");
		String subjectNo = request.getParameter("subjectNo");
		String opeType = request.getParameter("opeType");
		String term = request.getParameter("term");
		//判断参数
		if (leftNum == null 
				|| subjectNo == null
					|| opeType == null
						|| term == null) {
			message = "参数错误";
		}else {
			//设置参数信息
			params.put("subjectNo", Integer.parseInt(subjectNo));
			params.put("leftNum", Integer.parseInt(leftNum));
			params.put("opeType", opeType);
			params.put("studentNo",session.getAttribute("account"));
			params.put("term", term);
			try {
				message = subjectService.operateSubject(params);		//调用service操作方法
			} catch (UnusualParamsException e) {
				// TODO: handle exception
				message = e.getMessage();
			}catch (SubNumberOutOfRange e) {
				// TODO: handle exception
				message = e.getMessage();
			}
		}
	
		return SUCCESS;
	}
	
	/**
	 * TODO 审核选题信息
	 * @return 
	 */
	public String verifySubject(){
		message = "审核成功";
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
		
		return SUCCESS;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
