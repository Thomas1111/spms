package jxau.spms.tutor.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import jxau.spms.exception.UnusualParamsException;
import jxau.spms.tutor.po.TutorBasicInfo;
import jxau.spms.tutor.service.TutorService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 * 2014-8-27
 * TODO
 */
public class ModifyTutorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private TutorService tutorService;
	HttpServletRequest request;
	
	
	/**
	 * Administrator
	 * TODO
	 * 下午8:50:22
	 * @return
	 */
	public void modifyTutor(){
		
		String message = " ";
		request = ServletActionContext.getRequest();
		PrintWriter out = null;
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		//获取参数，设置属性
		TutorBasicInfo tutor = new TutorBasicInfo();
		String method = (String)request.getParameter("method");
		if ("state".equals(method)) {		//判断是否是管理员禁用方法
			System.out.print("****************");
			tutor.setTutorState(0);		//更改导师状态
			message = "禁用成功!";
		}
		tutor.setTutorNo((String) request.getParameter("tutorNo"));
		tutor.setCollege((String)request.getParameter("college"));
		tutor.setDirection((String)request.getParameter("direction"));
		try {
			tutorService.updateTutor(tutor);	//调用service更新方法
			out = ServletActionContext.getResponse().getWriter();
			out.print(message);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
			out.print(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (out != null) {
			out.flush();
			out.close();
		}
	
	}
	
	@Resource(name="tutorService")
	public void setTutorService(TutorService tutorService){
		this.tutorService = tutorService;
	}
	
}
