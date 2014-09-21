package jxau.spms.phaseManagement.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jxau.spms.common.po.DocumentType;
import jxau.spms.common.vo.PhaseMissionVo;
import jxau.spms.exception.CommonErrorException;
import jxau.spms.exception.UnusualParamsException;
import jxau.spms.phaseManagement.service.PhaseMissionService;
import jxau.spms.student.po.StuMissionInfo;
import jxau.spms.util.FileUpload;

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
	private List<DocumentType> docType; 
	// 封装上传文件域的属性  
    private File upload;
	private String message;
	
	@Resource(name="phaseMissionService")
	public void setPhaseMissionService(PhaseMissionService phaseMissionService){
	    this.phaseMissionService = phaseMissionService;
	}
	
	/**
	 * TODO 获取学生上传文件类型信息
	 * 上午10:00:05
	 * @return
	 */
	public String getDocumentType(){
		message = "加载成功";
		
		try {
			docType = phaseMissionService.queryDocType(null);
		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
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
		String tutorNo = (String) session.getAttribute("tutorNo");
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

    /**
	 * TODO 学生上传阶段任务
	 */
	public void uploadPhaMission(){
		message = "添加成功";
		StuMissionInfo stuMissionInfo = new StuMissionInfo();
		String missionNo = request.getParameter("missionNo");		//获取任务编号
		String term = request.getParameter("term");	//获取当前学期
		if (missionNo == null || term == null) {
			message = "参数异常";
		}
		//获取学生学号
		String studentNo = (String) session.getAttribute("studentNo");
		stuMissionInfo.setStudentNo(studentNo);			//设置学生学号
		stuMissionInfo.setMissionNo(Integer.parseInt(missionNo.trim()));	//设置任务编号
		stuMissionInfo.setUploadTime(new Date());	//设置上传时间	
		stuMissionInfo.setMissionName(request.getParameter("fileName"));//设置文件名称
		try {
			FileUpload.upload(term + File.separator + studentNo,upload,
					stuMissionInfo.getMissionName(),"phaseMission");	//调用上传工具类方法	
			phaseMissionService.uploadPhaMission(stuMissionInfo);	//调用service更新方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
	}
	/**
	 * TODO 导师审核学生阶段任务信息
	 * 下午7:24:05
	 */
	public String verifyStuPhaMis(){
		message = "审核成功";
		HashMap<String, Object> params = new HashMap<>();
		String missionNo = request.getParameter("missionNo");		//获取任务编号
		String studentNo = request.getParameter("studentNo");		//获取学生学号
		String verType = request.getParameter("verType");		//获取审核操作类型
		if ("pass".equals(verType) 		//判断审核操作类型
				|| verType == null) {
			params.put("exameState", 1);	//设置状态为"通过"
		}else {
			params.put("exameState", 3);	//设置状态为"不通过"
		}
		
		//设置审核参数
		params.put("studentNo", studentNo);
		params.put("missionNo", missionNo);
		try {
			phaseMissionService.verifyStuPhaMis(params);	//调用service方法
		} catch (UnusualParamsException e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		
		return SUCCESS;
	}
	
	
	public List<DocumentType> getDocType() {
		return docType;
	}

	public void setDocType(List<DocumentType> docType) {
		this.docType = docType;
	}

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
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
