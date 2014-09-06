package jxau.spms.subjectManagement.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import jxau.spms.common.po.SubjectInfo;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.subjectManagement.service.SubjectService;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

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
		if (subType == null || subSurce == null) {
			message = "请填写必要信息";
			request.setAttribute("message", message);
			return SUCCESS;
		}
		//选择选题类型信息
		switch (subType) {
		case "ministry":
			subType = "实际运用研究";
			break;
		case "theory":
			subType = "理论研究";
			break;
		case "praAndTheory":
			subType = "运用于理论结合研究";
			break;
		default:
			break;
		}
		//选择选题来源信息
		switch (subSurce) {
		case "ministry":
			subSurce = "省部级以上";         
			break;
		case "fee":
			subSurce = "横向且有经费";
			break;
		case "selectOn":
			subSurce = "自选";
			break;
		case "city":
			subSurce = "市厅级";
			break;
		default:
			break;
		}
		//实例化选题信息对象
		SubjectInfo subjectInfo = new SubjectInfo();
		//设置选题对象信息
		subjectInfo.setSubBrief(request.getParameter("intruduce"));
		subjectInfo.setPapLocation(request.getParameter("subLocation"));
		subjectInfo.setSubName(request.getParameter("subName"));	//设置
		subjectInfo.setSubPosition(request.getParameter("sourceType"));
		subjectInfo.setSubSource(subSurce);
		subjectInfo.setSubTerm(request.getParameter("subName"));
		subjectInfo.setSubType(subType);
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
