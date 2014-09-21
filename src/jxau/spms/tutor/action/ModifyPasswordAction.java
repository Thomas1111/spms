package jxau.spms.tutor.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import jxau.spms.common.vo.PassModification;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.tutor.service.TutorService;

public class ModifyPasswordAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private TutorService tutorService;
	HttpServletRequest request;
	private Map<String, Object> session;	
	/**
	 * 修改导师密码
	 * @return 返回跳转页面标识符
	 * */
	public String modifyPass(){
		String message = "";
		request = ServletActionContext.getRequest();
		PassModification modify = new PassModification();		//实例化修改密码对象
		//设置密码对象相应的属性
		int role = (int) session.get("role");
		modify.setRole(role);
		modify.setRealPass((String)session.get("password"));
		modify.setPassword((String)request.getParameter("originPass"));
		modify.setModifyPass((String)request.getParameter("modifyPass"));
		modify.setConfirmPass((String)request.getParameter("confirmPass"));
		//判断角色
		if (role == 1) {
			modify.setAccount((String) session.get("studentNo"));		
		}else if (role==2) {
			modify.setAccount((String) session.get("tutorNo"));	
		}else {
			modify.setAccount((String) session.get("adminNo"));	
		}
		//调用service方法获取信息
		try {
			message = tutorService.updatePass(modify);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		request.setAttribute("message", message);
		return "success";
	}
	
	@Resource(name="tutorService")
	public void setTutorService(TutorService tutorService){
		this.tutorService = tutorService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
