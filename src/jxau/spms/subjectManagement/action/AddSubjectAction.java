package jxau.spms.subjectManagement.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Lai Huiqiang 
 * 2014-9-6
 * TODO 增加选题信息
 */
@Controller("addSubjectAction")
@Scope("prototype")
public class AddSubjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SubjectService subjectService;
	private HttpServletRequest request;

	@Resource(name="subjectService")
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	/**
	 * TODO 
	 * @return 
	 */
	public String addSubject(){
		
		String message = "插入成功";
		request = ServletActionContext.getRequest();
		String subType = request.getParameter("subType");	//获取选题类型
		String subSurce = request.getParameter("subSource");	//获取选题来源
		String subBrief = request.getParameter("intruduce");
		String papLocation = request.getParameter("subLocation");
		String subName = request.getParameter("subName");
		String sourceType = request.getParameter("sourceType");
		String subTerm = request.getParameter("subTerm");
		//判断选题信息是否为空
		if (subType == null || subSurce == null 
				|| subBrief == null || papLocation == null
					|| subName == null|| sourceType == null
						|| subTerm == null) {
			message = "请填写必要信息";
			request.setAttribute("message", message);
			return SUCCESS;
		}
		
		//实例化选题信息对象
		SubjectInfo subjectInfo = new SubjectInfo();
		//生成上报时间
		SimpleDateFormat format = new SimpleDateFormat
				("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(new Date());
		//设置选题对象信息
		subjectInfo.setSubBrief(subBrief);
		subjectInfo.setPapLocation(papLocation);
		subjectInfo.setSubName(subName);	//设置
		subjectInfo.setSubPosition(sourceType);
		subjectInfo.setSubSource(subSurce);
		subjectInfo.setSubTerm(subTerm);
		subjectInfo.setSubType(subType);
		subjectInfo.setApplyTime(currentTime);
		subjectInfo.setTutorNo((String)request.
				getSession().getAttribute("account"));
		
		try {
			subjectService.addSubject(subjectInfo);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		return SUCCESS;
	}
}
