package jxau.spms.notice.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.spms.admin.po.NoticeInfo;
import jxau.spms.exception.NoticeNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.notice.service.NoticeService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang 
 * 2014-9-4
 * TODO 显示公告信息
 */
@Controller("queryNoticeAction")
@Scope("prototype")
public class QueryNoticeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private HttpSession session;
	private HttpServletRequest request;
	
	@Resource(name="noiceService")
	public void setNoticeService(NoticeService noticeService){
		this.noticeService = noticeService;
	}
	
	public String queryNotice(){
		request = ServletActionContext.getRequest();
		session = request.getSession();
		List<NoticeInfo> noticeInfos = null;
		//获取参数信息
		int role = (int) session.getAttribute("role");
		String account = null;
		//判断角色
		if (role == 1) {
			account = (String) session.getAttribute("studentNo");		
		}else if (role==2) {
			account = (String) session.getAttribute("tutorNo");	
		}else {
			account = (String) session.getAttribute("adminNo");	
		}
		HashMap< String, Object> params = new HashMap<>();
		//设置查询条件
		params.put("role", role);
		params.put("account", account);
		//调用service查询方法
		try {
			noticeInfos = noticeService.queryNotice(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return "success";
		}catch (NoticeNotExistException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return "success";
		}
		request.setAttribute("noticeInfos", noticeInfos);
		return "success";
	}
	
}
