package jxau.spms.student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.StudentNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.service.StudentService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang 
 * 2014-8-30
 * TODO 查询导师所带学生基本信息
 */
@Controller("queryStudentAsyc")
@Scope("prototype")
public class QueryStudentAsyc extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private StudentService studentService;
	private HttpServletRequest request;
	private HttpSession session;
	private List<StuBasicInfo> stuBasicInfos;
	private PageVo pageVo;
	
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	/**
	 * TODO 预处理查询学生基本信息
	 * 上午10:27:38
	 * @return 跳转标记位
	 */
	public String queryStudent(){
		HashMap< String, Object> params = new HashMap<>();		//查询条件
		request = ServletActionContext.getRequest();
		session = request.getSession();
		String tutorNo;
		int role = (int) session.getAttribute("role");		//获取角色编号
		if (role == 3) {
			tutorNo = (String) request.getParameter("tutorNo");
		}else {
			//获取导师工号
			tutorNo = (String) session.getAttribute("tutorNo");
		}
		String term = request.getParameter("term");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageVo = new PageVo();	//实例化分页对象
		pageVo.setCurrentPage(currentPage);
		//设置查询条件 
		params.put("tutorNo", tutorNo);
		params.put("term", term);		//设置学生所属的学期
		params.put("start", pageVo.getFirstIndex());
		params.put("number", pageVo.getSize());
		try {
			stuBasicInfos = studentService.queryTutorStu(params);	//调用service查询方法
			pageVo.setCount(studentService.queryStuNumber(params)); //设置符合条件数量,获取最大的页数
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}catch (StudentNotExistException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		} 
		return SUCCESS;
	}
	
	public List<StuBasicInfo> getStuBasicInfos() {
		return stuBasicInfos;
	}
	public void setStuBasicInfos(List<StuBasicInfo> stuBasicInfos) {
		this.stuBasicInfos = stuBasicInfos;
	}
	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
}
