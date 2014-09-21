package jxau.spms.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxau.spms.exception.UnusualParamsException;
import jxau.spms.login.service.LoginService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	private Map<String,Object> session;
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	@Resource(name="loginService")
	public void setLoginService(LoginService loginService){		//注入loginService
		this.loginService = loginService;
	}
	/**
	 * 用户登录
	 * @return 返回跳转页面标识符
	 * */
	public String login(){
		//获取参数信息
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String roleInfo = request.getParameter("role");
		if (roleInfo == null || " ".equals(roleInfo)) {
			return SUCCESS;
		}
		int role = Integer.valueOf(roleInfo.trim());
		HashMap<String, String> message = null;			//返回信息内容
		PrintWriter out = null;
		Map<String, Object> params = new HashMap<String, Object>();
		//设置字符编码，解决乱码
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");		
		try {
			out = response.getWriter();
			if ("".equals(account)||account == null
					||"".equals(password)||password == null) {
				 out.print("账号或者密码不能为空!");
				 return SUCCESS;
			}else {
				params.put("account", account);
				params.put("password", password);
				//调用service方法识别用户
				message = (HashMap<String, String>) loginService.identifyUser(role, params);
				if (message != null && message.get("name")!=null) {		//session记录登录信息
					String name = message.get("name");
					if (role == 1) {
						session.put("studentNo", account);
						session.put("studentName",name);
					}else if (role == 2) {
						session.put("tutorNo",account);
						session.put("tutorName",name);
					}else {
						session.put("adminNo", account);
						session.put("adminName",name);
					}
					session.put("role", role);
					session.put("password", password);
				}
				out.print(message.get("info"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(UnusualParamsException e){
			System.out.println(e.getMessage());
		}finally{
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		return SUCCESS;
	}
	
	/**
	 * TODO 用户登出系统
	 * 下午2:43:33
	 * @return
	 */
	public String loginOut(){

		int role = (int) session.get("role");	//获取当前角色名称
		//清除session信息
		if (role == 1) {
			session.remove("studentNo");
			session.remove("studentName");
		}else if (role == 2) {
			session.remove("tutorNo");
			session.remove("tutorName");
		}else {
			session.remove("adminNo");
			session.remove("adminName");
		}
		session.remove("role");
		session.remove("password");
		
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
}
