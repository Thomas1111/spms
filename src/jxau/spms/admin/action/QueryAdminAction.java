package jxau.spms.admin.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.admin.po.AdminBasicInfo;
import jxau.spms.admin.service.AdminService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-8-31
 * TODO 获取管理员基本信息
 */
@Controller("queryAdminAction")
@Scope("prototype")
public class QueryAdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private AdminService adminService;
	
	@Resource(name="adminService")
	public void setAdminService(AdminService adminService){
		this.adminService = adminService;
	}
	
	/**
	 * TODO 查询
	 * @return 跳转标记位
	 */
	public String queryAdmin(){
		HashMap<String, Object> params = new HashMap<String, Object>();
		String adminNo = (String) session.getAttribute("account");
		params.put("adminNo", adminNo);		//设置查询参数
		//调用service方法
		AdminBasicInfo adminBasicInfo = adminService.queryAdminByNo(params);
		if (adminBasicInfo == null) {	//判断用户是否存在
			System.out.println("用户不存在!");
		}
		request.setAttribute("adminBasicInfo", adminBasicInfo);		//设置requset属性
		
		return "success";
	}
}
