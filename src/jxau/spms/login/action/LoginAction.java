package jxau.spms.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.login.service.LoginService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

@Controller("displayCollegeAction")
@Scope("prototype")
public class LoginAction extends ActionSupport implements SessionAware{
	
	private LoginService loginService;
	private Map<String,Object> session;
	
	@Resource(name="loginService")
	public void setLoginService(LoginService loginService){		//注入loginService
		this.loginService = loginService;
	}
	/**
	 * 用户登录
	 * @return 返回跳转页面标识符
	 * */
	public String login(){
		String flag = "error";	//跳转页面标识符
		//获取参数信息
		String account = ServletActionContext.getRequest().getParameter("account");
		String password = ServletActionContext.getRequest().getParameter("password");
		int role = Integer.valueOf((String)ServletActionContext.getRequest().getParameter("role"));
		HashMap<String, String> message = null;			//返回信息内容
		PrintWriter out = null;
		Map<String, Object> params = new HashMap<String, Object>();
		//设置字符编码，解决乱码
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");		
		try {
			out = ServletActionContext.getResponse().getWriter();
			if ("".equals(account)||account == null
					||"".equals(password)||password == null) {
				 out.print("账号或者密码不能为空!");
				 return flag;
			}else {
				params.put("account", account);
				params.put("password", password);
				//调用service方法识别用户
				message = (HashMap<String, String>) loginService.identifyUser(role, params);
				if (message != null && message.get("name")!=null) {		//session记录登录信息
					session.put("name", message.get("name"));
					session.put("account", account);
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
		return flag;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
}
