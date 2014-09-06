package jxau.spms.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import jxau.spms.common.po.TermInfo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.student.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-1
 * TODO 获取学期信息处理类
 */
@Controller("queryTermAction")
@Scope("prototype")
public class QueryTermAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private StudentService studentService;
	
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	/**
	 * TODO 获取学期信息
	 * 下午2:59:11
	 */
	public String queryTerm() {
		String message = "学期信息已加载";
		PrintWriter out = null;
		 List<TermInfo> terms = null;
		HashMap<String, Object> params = new HashMap<>();
		try {
			 out = ServletActionContext.getResponse().getWriter();
			 terms = studentService.queryTerms(params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		System.out.println("********===" + message);
		String termInfo = new Gson().toJson(terms);		//将对象转化为json格式内容
		out.print(termInfo);		//输出学期信息
		//关闭输出流
		out.flush();
		out.close();
		
		return "success";
	}
}
