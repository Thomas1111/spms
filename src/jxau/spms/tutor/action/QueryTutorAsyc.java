package jxau.spms.tutor.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxau.spms.common.vo.PageVo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.tutor.po.TutorBasicInfo;
import jxau.spms.tutor.service.TutorService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("queryTutorAsyc")
@Scope("prototype")
public class QueryTutorAsyc extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private Map<String, Object> session;	
	private TutorService tutorService;
	List<TutorBasicInfo> tutors;
	String message;
	PageVo pageVo;
	/**
	 * 查询导师信息(导师、管理员)
	 * @return 重定向位置标识
	 * 
	*/
	public String queryTutor(){
		message = "导师信息加载成功";
		HashMap<String, Object> params = new HashMap<>();		//查询输入条件
		pageVo = new PageVo();
		String adminNo = (String) session.get("adminNo");		//获取管理员账号
		String term = (String) request.getParameter("term");
		//设置当前页面数
		pageVo.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pageVo.setCount(tutorService.queryTutorNumber(params));		//获取导师数量
		//if (tutorNo != null) {		//判断管理员是否查询单个导师信息
			params.put("adminNo", adminNo);		//存储管理员账号
			try {
				params.put("start", pageVo.getFirstIndex());	//设置起始序数
				params.put("number", pageVo.getSize());		//设置选取数量
				params.put("term", term);
					//调用service选择导师方法
				tutors = tutorService.queryTutors(params);		//调用service查询导师信息
				if (tutors == null||tutors.size() == 0) {	//判断符合条件的导师数量
					message = "当前还未分配导师!";
				}
				} catch (UnusualParamsException e) {
					// TODO: handle exception
					message = e.getMessage();
				}
		/*}else {
			message = "导师账号参数为空！";
		}*/
		
		return SUCCESS;
	}
	
	public List<TutorBasicInfo> getTutors() {
		return tutors;
	}
	public void setTutors(List<TutorBasicInfo> tutors) {
		this.tutors = tutors;
	}
	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
