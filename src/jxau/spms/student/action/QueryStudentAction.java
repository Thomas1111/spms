package jxau.spms.student.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.StudentNotExistException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.student.po.StuBasicInfo;
import jxau.spms.student.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang 
 * 2014-8-30
 * TODO 查询导师所带学生基本信息
 */
@Controller("queryStudentAction")
@Scope("prototype")
public class QueryStudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private StudentService studentService;
	private HttpServletRequest request;
	
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
		String flag = "tutorDoc";		//跳转的标记位
		request = ServletActionContext.getRequest();
		List<StuBasicInfo> stuBasicInfos = null;
		HashMap< String, Object> params = new HashMap<>();		//查询条件
		//获取导师工号
		String tutorNo = request.getParameter("tutorNo");
		String operationNo = request.getParameter("operationNo");
		String term = request.getParameter("term");
		PageVo  pageVo = null;
		//根据操作序号选择不同的跳转路径
		switch (operationNo) {		
		case "tutorStu":
			pageVo = setPageVo(params);		
			flag = operationNo;		//设置跳转标识符
			break;
		case "adminStu":
			pageVo = setPageVo(params);
			request.setAttribute("tutorNo",tutorNo);
			flag = operationNo;		//设置跳转标识符
			break;
		default:
			break;
		}
		//设置查询条件 
		params.put("tutorNo", tutorNo);
		params.put("term", term);		//设置学生所属的学期
		try {
			stuBasicInfos = studentService.queryTutorStu(params);	//调用service查询方法
			if (pageVo != null) {
				pageVo.setCount(studentService.queryStuNumber(params)); //设置符合条件数量,获取最大的页数
				request.setAttribute("pageVo", pageVo); 	//设置request分页属性
			}
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}catch (StudentNotExistException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		request.setAttribute("stuBasicInfos", stuBasicInfos);	//设置学生信息属性
		request.setAttribute("term", term);		//设置当前学期
		
		return flag;
	}
	
	/**
	 * TODO 获取分页对象
	 * @param params 查询参数
	 * @return 分页对象
	 */
	public PageVo setPageVo(HashMap<String, Object> params){
		PageVo pageVo = new PageVo();		//实例化分页对象
		pageVo.setCurrentPage(Integer.parseInt
				(request.getParameter("currentPage")));		//设置当前页面
		params.put("start", pageVo.getFirstIndex());	//设置起始序数参数
		params.put("number", pageVo.getSize());		//设置显示数量参数
		return pageVo;
	}
}
