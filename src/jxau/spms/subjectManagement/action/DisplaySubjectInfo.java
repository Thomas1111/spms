package jxau.spms.subjectManagement.action;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.common.vo.PageVo;
import jxau.spms.common.vo.SpecificSubjectVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("displaySubjectInfo")
@Scope("prototype")
public class DisplaySubjectInfo extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private SubjectService subjectService;
	private HttpServletRequest request = ServletActionContext.getRequest();
	//private HttpSession session = request.getSession();
	private List<SubjectInfo> subjectInfos;
	private PageVo pageVo = null;
	private String message;

	@Resource(name="subjectService")
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	/**
	 * TODO 显示管理员审核导师选题信息
	 * 下午3:28:17
	 * @return 
	 */
	public String displaySubInfo(){
		String flag = "verify";
		message = "加载成功";
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		String term =request.getParameter("term");		//获取学期信息
		String currentPage =request.getParameter("currentPage");		//获取学期信息
		String tutorNo = (String) request.getParameter("tutorNo");	//管理员获取导师工号
		params.put("tutorNo",tutorNo);		//设置导师工号
		params.put("term",term);	//设置学期参数
		pageVo = new PageVo();
		if(currentPage == null){		//判断currentPage是否为空
			message = "参数错误";
			return flag;
		}
		pageVo.setCurrentPage(Integer.parseInt(currentPage.trim()));	//设置当前页
		try {
			subjectInfos = subjectService.querySubject(params, pageVo,null);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		//设置request属性
		request.setAttribute("subjectInfos", subjectInfos);
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("message", message);
		
		return flag;
	}
	/**
	 * TODO 显示导师选题详细信息
	 * 下午3:28:17
	 * @return 
	 */
	public String displaySpecificSub(){
		String flag = "specificInfo";
		message = "加载成功";
		//设置查询条件
		HashMap<String, Object> params = new HashMap<>();
		String subjectNo =request.getParameter("subjectNo");		//获取学期信息
		params.put("subjectNo",subjectNo);		//设置选题编号
		System.out.print("****"+subjectNo);
		SpecificSubjectVo speSubVo = null;
		try {
			speSubVo = subjectService.querySpeSub(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		//设置request属性
		request.setAttribute("speSubVo", speSubVo);
		request.setAttribute("message", message);
		System.out.print("flag"+flag);
		return flag;
	}
}
