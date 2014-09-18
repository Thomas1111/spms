package jxau.spms.phaseManagement.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jxau.spms.common.vo.PhaseMissionVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Lai Huiqiang
 * 2014-9-17
 * TODO 异步加载获取发送对象信息
 */
@Controller("phaseMissionAys")
@Scope("prototype")
public class PhaseMissionAys extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private PhaseMissionService phaseMissionService ;
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	private List<PhaseMissionVo> phaseMissionVo;
	private String message;
	
	@Resource(name="phaseMissionService")
	public void setPhaseMissionService(PhaseMissionService phaseMissionService){
	    this.phaseMissionService = phaseMissionService;
	}
	
	/**
	 * TODO 导师获取发送对象信息
	 * 上午11:01:43
	 * @return 
	 */
	public String getSendObject(){
		message = "加载成功";
		HashMap<String, Object> params = new HashMap<>();
		//获取导师账号
		String tutorNo = (String) session.getAttribute("account");
		String term = request.getParameter("term");	//获取学期信息
		params.put("tutorNo", tutorNo);		//设置导师账号参数
		params.put("term", term);
		//调用service方法
		try {
			phaseMissionVo = phaseMissionService.querySendObject(params);
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (CommonErrorException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}

	public List<PhaseMissionVo> getPhaseMissionVo() {
		return phaseMissionVo;
	}

	public void setPhaseMissionVo(List<PhaseMissionVo> phaseMissionVo) {
		this.phaseMissionVo = phaseMissionVo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
